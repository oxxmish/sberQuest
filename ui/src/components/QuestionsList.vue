<template>
     <div id="main_area">
        <div v-if="draw === 'questions'" class="grid" id="grid">
            <div class="scroll">
                <div class="grid_element" v-for="(option, index) in get_questions()" @click="choose_question" :key="index" :fake_id="option.tmp_id" v-bind:el_id="option.id">{{ option.shortText }}</div>
                <div class="grid_element plus" @click="add_question">+</div>
                <div class="grid_element load" id="load" @click="load_questions">Загрузить из файла</div>
            </div>
        </div>
        <div id="edit_window" class="edit_window" v-if="draw === 'edit'">
            <img @click="to_questions" src="@/assets/go_back.png" alt="">
            <input id="edit_window_input" class="edit_window_input" placeholder="Введите новое название продукта" />
            <div class="edit_window_color_title">Выберите новый цвет поля</div>
            <div class="edit_window_group_color">
                <div id="color_example">
                    <output id="hex">#000000</output>
                </div>
                <fieldset>
                <label for="r">R</label>
                <input type="range" min="0" max="255" id="r" step="1" value="0">
                <output for="r" id="r_out">0</output>
                </fieldset>  
                
                
                <fieldset>
                <label for="g">G</label>
                <input type="range" min="0" max="255" id="g" step="1" value="0">
                <output for="g" id="g_out">0</output>
                </fieldset>

                
                
                <fieldset>
                <label for="b">B</label>
                <input type="range" min="0" max="255" id="b" step="1" value="0">
                <output for="b" id="b_out">0</output>
                </fieldset>  
                    
                    
            </div>
            <div class="edit_window_group_button">
                <div @click="save_edit" class="edit_window_button">Сохранить</div>
                <div @click="reset" class="edit_window_button">Сбросить</div>
            </div>
        </div>
        <div v-if="draw === 'delete'" class="delete_product_window" id="delete_product_window">
            <div id="delete_product_warning">
                Вы действительно хотите удалить поле "{{selected_product[0]}}" и все связанные с ним задания?
            </div>
            <div class="delete_window_group_button">
                <div @click="delete_product" class="button">Да</div>
                <div @click="cancel_product" class="button">Нет</div>
            </div>
        </div>
        <div v-if="draw === 'edit_question'" class="edit_question" id="edit_question">
            <div id="first_line" style="width:100%;">
                <img style="height:75%;width:7.5%;float:left;margin-right:5%" @click="to_questions" src="@/assets/go_back.png" alt="">
                <div style="width:50%;float:left;" id="short_name_header" resize="false">Краткое обозначение вопроса</div>
                <input style="float:left;width:30%;" type="text" maxlength="16" id="short_name" @blur="save_short_name" :value="selected_el.shortText" >
                <!-- <div style="width:30%;float:left;" id="category_header">Категория вопроса</div> -->
            </div>
            <div id="second_line" style="width:100%; height:15%;">
                <!-- <input style="float:left;width:30%;" type="text" maxlength="16" id="short_name" @blur="save_short_name" :value="selected_el.shortText" > -->
                <div style="width:30%;float:left;" id="category_header">Категория вопроса</div>
                <select style="float:left;width:30%;" id="type_selector">
                    <option>С выбором ответа</option>
                    <option>Без выбора ответа</option>
                    <option>Вопрос-аукцион</option>
                    <option>Вопрос с медиа фрагментом</option>
                </select>
            </div>
            <!-- <div id="third_line">
                <div id="short_name_header" resize="false">Краткое обозначение вопроса</div>
            </div> -->
            <!-- <div id="fourth_line">
                <input type="text" maxlength="16" id="short_name" @blur="save_short_name" :value="selected_el.shortText" >
            </div> -->
            <div id="fiveth_line">
                <div id="wording_header" resize="false">Формулировка вопроса</div>
            </div>
            <textarea rows="12" id="wording" :value="selected_el.text"></textarea>
            <div id="fiveth_line">
                <div id="wording_header" resize="false">Ответ</div>
            </div>
            <textarea rows="2" id="answer" :value="selected_el.answer"></textarea>
            <div class="delete_window_group_button">
                <div @click="save_question" class="button">Сохранить</div>
                <div @click="del_question" class="button">Удалить</div>
            </div>
            
            <!-- <input type="file" id="file-uploader" v-if="selected_el.type === 'Вопрос с медиа фрагментом'"> -->
        </div>
        <div v-if="draw === 'delete_question'" class="delete_product_window" id="delete_product_window">
            <div id="delete_product_warning">
                Вы действительно хотите удалить {{ selected_el.text }}?
            </div>
            <div class="delete_window_group_button">
                <div @click="delete_question" class="button">Да</div>
                <div @click="cancel_question" class="button">Нет</div>
            </div>
        </div>
        <div id="pop_up" class="pop_up" v-if="load">
            <div class="pop_up_title">Загрузка заданий</div>

            <!-- <input id="pop_up_input" class="pop_up_input" placeholder="Путь до файла"></input>
            <img type="file" @click="to_questions" src="media/load.png" class="load_path" alt=""> -->

            <input type="file" id="file-uploader" >
            <div class="pop_up_group_button">
                <div class="pop_up_button">Загрузить</div>
                <div @click="cancel_load" class="pop_up_button">Отмена</div>
            </div>
        </div>
    </div>
</template>

<script>
let wording = '';
let type = '';

export default {
  name: 'QuestionsList',
  props:['selected_product', 'products'],
  data(){
    return {
            selected: '1',
            selected_el: null,
            draw: 'questions'
    }
  },
  methods: {
        add_product: function () {
            this.$emit('add-field');
        },
        cancel_product: function () {
            var edit = document.getElementById("edit");
            var click_delete = document.getElementById("delete");
            click_delete.style.opacity = 1;
            edit.style.opacity = 1;
            this.draw = 'questions';
        },
        delete_product: function () {
            this.draw = 'questions';
            this.$emit('final-delete-product');
        },
        to_questions: function () {
            this.draw = 'questions';
            var edit = document.getElementById("edit");
            var click_delete = document.getElementById("delete");
            click_delete.style.opacity = 1;
            edit.style.opacity = 1;
        },
        save_edit: function () {
            var avatar = document.getElementById("avatar");
            var color = String(document.getElementById('hex').value);
            avatar.style.backgroundColor = color;
            var name = document.getElementById("edit_window_input").value;
            console.log(name);
            if(name != "")
            {
                avatar.textContent = name.value;
                document.getElementById("edit_window_input").value = '';
                this.draw = 'questions';
                this.$emit('final-edit-product', name, 'color:white;background:' + color);
            }
            else
            {
                console.log(this.selected_product[0]);
                this.$emit('final-edit-product', this.selected_product[0], 'color:white;background:' + color);
                this.draw = 'questions';
            }
            var edit = document.getElementById("edit");
            var click_delete = document.getElementById("delete");
            click_delete.style.opacity = 1;
            edit.style.opacity = 1;
        },
        choose_question: function (event) {
            this.draw = 'edit_question';
            this.selected = event.target.getAttribute("el_id");
            let fake_id = event.target.getAttribute("fake_id");
            var cur_el;
            var local_selected = this.selected;
            this.get_questions().forEach(function(item) {
                if(local_selected && local_selected == item.id)
                    cur_el = item;
                else if(fake_id && item.tmp_id == fake_id)
                    cur_el = item;
            });
            this.selected_el = cur_el;
            let mapping = new Map();
            mapping.set("TEXT", "Без выбора ответа").set("AUCTION", "Вопрос-аукцион").set("TEXT_WITH_ANSWERS", "С выбором ответа").set("MEDIA", "Вопрос с медиа фрагментом");
            wording = cur_el.text;
            
            type = mapping.get(cur_el.questionType);
            // if(document.getElementById("type_selector"))
            // {
            //     document.getElementById("type_selector").value = mapping.get(this.selected_el.questionType);
            //     // document.getElementById("wording").value = this.selected_el.text;
            // }
            
        },
        del_question: function () {
            this.draw = 'delete_question';
        },
        delete_question: function () {
            this.draw = 'questions';
            var product_name = this.selected_product[0];
            var deleted_question = this.selected;
            this.products.forEach(function(item) {
                if(product_name == item.text)
                    item.questions = item.questions.filter(option => option.id != deleted_question);
            });
        },
        cancel_question: function () {
            this.draw = 'edit_question';
        },
        save_question: function () {
            console.log(this.selected_el);
            let mapping = new Map();
            mapping.set("Без выбора ответа", "TEXT").set("Вопрос-аукцион", "AUCTION").set("С выбором ответа", "TEXT_WITH_ANSWERS").set("Вопрос с медиа фрагментом", "MEDIA");
            this.$emit('edit-question', this.selected_product[0], this.selected_el, this.selected, mapping.get(document.getElementById("type_selector").value), document.getElementById("wording").value, document.getElementById('short_name').value, document.getElementById('answer').value);
            this.draw = 'questions';
        },
        get_questions: function () {
            var product_name = this.selected_product[0];
            var questions;
            this.products.forEach(function(item) {
                if(product_name == item.text)
                    questions = item.questions;
            });
            return questions;
        },
        add_question: function () {
            this.$emit('add-question', this.selected_product[0]);
        },
        check_delete_product: function () {
            this.draw = 'delete';
        },
        edit_product: function () {
            this.draw = 'edit';
        },
        save_short_name: function () {
            var product_name = this.selected_product[0];
            var selected = this.selected_el;
            this.products.forEach(function(item) {
                if(product_name == item.text)
                    item.questions.forEach(function(inner_item) {
                        if(selected == inner_item)
                            inner_item.shortText = document.getElementById('short_name').value;
                        
                    });
            });
        },
  }
}

document.addEventListener("DOMNodeInserted", function () {
            if(document.querySelector('#r') == null)
                return;
            var product = document.getElementById("color_example"), 
            r = document.querySelector('#r'),
            g = document.querySelector('#g'),
            b = document.querySelector('#b'),
            r_out = document.querySelector('#r_out'),
            g_out = document.querySelector('#g_out'),
            b_out = document.querySelector('#b_out'),
            hex_out = document.querySelector('#hex');

            function setColor(){
            var r_hex = parseInt(r.value, 10).toString(16),
                g_hex = parseInt(g.value, 10).toString(16),
                b_hex = parseInt(b.value, 10).toString(16),
                hex = "#" + pad(r_hex) + pad(g_hex) + pad(b_hex);
                product.style.backgroundColor = hex; 
            hex_out.value = hex;
            }

            function pad(n){
            return (n.length<2) ? "0"+n : n;
            }

            r.addEventListener('change', function() {
            setColor();
            r_out.value = r.value;
            }, false);

            r.addEventListener('input', function() {
            setColor();
            r_out.value = r.value;
            }, false);

            g.addEventListener('change', function() {
            setColor();
            g_out.value = g.value;
            }, false);

            g.addEventListener('input', function() {
            setColor();
            g_out.value = g.value;
            }, false);

            b.addEventListener('change', function() {
            setColor();
            b_out.value = b.value;
            }, false);

            b.addEventListener('input', function() {
            setColor();
            b_out.value = b.value;
            }, false);
                
            }, false);

document.addEventListener("DOMNodeInserted", function () {
    if(document.getElementById("type_selector")){
        var selector = document.getElementById("type_selector");
        selector.value = type;
        var wording_1 = document.getElementById("wording");
        wording_1.value = wording;
    }
    
}, false);
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#main_area{
    float: left;
    height: 85%;
    width: 70%;
    
    margin-top: 3%;
    margin-left: 2%;
}

.grid{
    float: left;
    width: 100%;
    height: 100%;
}

.grid_element{
    margin-top: 1.1%;
    margin-left: 2%;
    margin-right: 2%;
    margin-bottom: 5%;
    float: left;
    width: 20%;
    height: 20%;
    border: 2px solid black;
    border-radius: 20px;
    text-align: center;
    /* font-size: 220%; */
    font-size: 1.5vw;
    /* line-height:100px; */
    line-height: 7vw;
    color: black;
    transition: transform .25s ease;
}

.grid_element:hover {
  transform: scale(1.1); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}

.plus, .load{
    border: 2px solid silver;
    color: silver;
}

.plus{
    /* font-size: 600%; */
    font-size: 6vw;
}

.load{
    /* font-size: 130%; */
    font-size: 1.3vw;
}

.scroll{
    height: 100%;
    overflow: auto;
    -ms-overflow-style: none;
    scrollbar-width: none;
}

.scroll::-webkit-scrollbar {
    width: 0;
    height: 0;
}

/* Pop up window */

.edit_window{
    float: left;
    position: fixed;
    width: 70%;
    height: 100%;
    background-color: white;
    text-align: center;
}

img{
    float: left;
    width: 7%;
    height: 7%;
}

.load_path{
    float: right;
    margin-top: 5%;
    margin-right: 8%;
    width: 12%;
    height: 12%;
}

.edit_window_color_title{
    margin-top: 4%;
    color: green;
    /* font-size: 150%; */
    font-size: 1.6vw;
    width: 90%;
    margin-left: 5%;
    text-align: center;
    font-weight: bold;
    margin-bottom: 3%;
}

input{
    /* margin-top: 5%; */
    width: 60%;
    border-bottom: 1.5px solid silver;
    border-top: none;
    border-left: none;
    border-right: none;
    outline:none;
    /* font-size: 150%; */
    font-size: 2vw;
}

#edit_window_input{
    margin-top: 5%;
    width: 80%;
}

.edit_window_group_button{
    margin-top: 5%;
    width: 90%;
    height: 20%;
    margin-left: 12%;
}

.edit_window_button{
    float: left;
    margin-left: 5%;
    margin-right: 5%;
    padding-top: 1%;
    padding-bottom: 1%;
    width: 30%;
    background-color: green;
    color: #ffffff;
    border-radius: 35px;
    /* font-size: 150%; */
    font-size: 1.5vw;
}

.edit_window_button:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

/* Shadow */

/* .opacity{
    position: absolute;
    width: 100%; height:100%;
    background:rgba(0,0,0,0.6);
} */

@import url(https://fonts.googleapis.com/css?family=Roboto:700);
fieldset{
  border: none;
  width: 50%;
  line-height: 135%;
}
output{
  display: inline-block;
  min-width: 2.5em;
}
label, output{
  /* padding: 2px 9px; */
  border-radius: 3px;
  font-family: 'Roboto', sans-serif;
  color: #000;
  font-size: 1.1em;
}
label{
    padding-left: 2%;
    padding-right: 2%;
}
label[for=r], output[for=r]{
  background-color: #f00;
}
label[for=g], output[for=g]{
  background-color: #0f0;
}
label[for=b], output[for=b]{
  background-color: #00f;
}
#hex{
  min-width: 4.5em;
  font-size: 3em;
  background: rgba(255,255,255,.3);
}

#color_example{
    float: right;
    width: 35%;
    height: 35%;
    padding-left: 2%;
    padding-right: 2%;
    padding-top: 4%;
    padding-bottom: 4%;
    border-radius: 20px;
    margin-top: 1%;
    margin-right: 5%;
    background-color: #000000;
}

#delete_product_window{
    margin-top: 13%;
    width: 100%;
}

#delete_product_warning{
    width: 80%;
    font-size: 250%;
    text-align: center;
}

.delete_window_group_button{
    width: 80%;
    margin-left: 15%;
}

.button{
    float: left;
    width: 30%;
    background-color: green;
    text-align: center;
    padding-top: 1.5%;
    padding-bottom: 1.5%;
    color: white;
    /* font-size: 120%; */
    font-size: 1.2vw;
    font-weight: bold;
    border-radius: 20px;
    margin-left: 4%;
    margin-right: 10%;
    margin-top: 5%;
}

.button:hover{
    box-shadow: 0 0 10px 100px orange inset;
}

#edit_question{
    height: 40%;
}

#type_selector{
    /* float: left; */
    width: 40%;
    /* font-size: 130%; */
    font-size: 1.3vw;
    padding-top: 0.5%;
    padding-bottom: 0.5%;
    margin-left: 20%;
    margin-bottom: 2%;
}

#title{
    float: left;
    width: 60%;
    /* font-size: 200%; */
    font-size: 2vw;
}

#wording{
    width: 70%;
    height: 85%;
    /* font-size: 140%; */
    font-size: 1.4vw;
    resize: none;
    margin-left: 12.5%;
    margin-top: 1%;
}


/* Pop up window */

.pop_up{
    float: left;
    position: fixed;
    width: 45%;
    height: 35%;
    background-color: white;
    text-align: center;
    border-radius: 20px;
    border: 2px solid black;
    left: 27.5%;
    top: 32.5%;
}

.pop_up_title{
    margin-top: 2%;
    color: green;
    /* font-size: 200%; */
    font-size: 2vw;
    font-weight: bold;
}
.pop_up_color_title{
    margin-top: 4%;
    color: green;
    /* font-size: 150%; */
    font-size: 1.5vw;
    width: 90%;
    margin-left: 5%;
    text-align: center;
    font-weight: bold;
    margin-bottom: 3%;
}

input{
    /* margin-top: 5%; */
    width: 60%;
    border-bottom: 1.5px solid silver;
    border-top: none;
    border-left: none;
    border-right: none;
    outline:none;
    /* font-size: 130%; */
    font-size: 1.3vw;
}

#pop_up_input{
    margin-top: 5%;
    margin-left: 5%;
    width: 70%;
}

.pop_up_group_button{
    margin-top: 5%;
    width: 90%;
    height: 20%;
    margin-left: 5%;
}

.pop_up_button{
    float: left;
    margin-left: 5%;
    margin-right: 5%;
    padding-top: 2.5%;
    padding-bottom: 2.5%;
    width: 40%;
    background-color: green;
    color: #ffffff;
    border-radius: 35px;
    /* font-size: 120%; */
    font-size: 1.2vw;
}

.pop_up_button:hover {
    box-shadow: 0 0 10px 100px orange inset;
}


#file-uploader{
    margin-top: 5%;
}

#short_name{
    width: 40%;
}

#category_header{
    font-size: 2vw;
    /* width: 70%; */
    margin-left: 12.5%;
}

#first_line{
    height: 20%;
}

#short_name_header{
    font-size: 2vw;
    /* margin-left: 15%; */
}

#wording_header{
    font-size: 2vw;
    margin-left: 12.5%;
    margin-top: 2%;
}

img{
    transition: transform .25s ease;
}

img:hover {
  transform: scale(1.1); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}

#answer{
    width: 70%;
    height: 30%;
    /* font-size: 140%; */
    font-size: 1.4vw;
    resize: none;
    margin-left: 12.5%;
    margin-top: 1%;
}
</style>
