<template>
    <div id="pop_up" class="pop_up" v-if="is_add_product">
        <div class="pop_up_title">Создание игрового поля</div>
        <input id="pop_up_input" class="pop_up_input" placeholder="Название продукта"/>
        <div class="pop_up_color_title">Выберите цвет поля</div>
        <div class="pop_up_group_color">
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
        <div class="pop_up_group_button">
            <div @click="create_product" class="pop_up_button">Сохранить</div>
            <div @click="exit" class="pop_up_button">Выйти</div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'AddFields',
  props:['is_add_product'],
  data(){
    return {
        
        }
    },
    methods:{
        exit: function () {
            this.$emit('close-add-field');
        },
        create_product: function () {
            var name = document.getElementById("pop_up_input").value;
            var color = String(document.getElementById('hex').value);
            this.$emit('create-field', name, color);
            this.$emit('close-add-field');
            document.getElementById("pop_up_input").value = "";
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.pop_up{
    float: left;
    position: fixed;
    width: 45%;
    height: 60%;
    background-color: white;
    text-align: center;
    border-radius: 20px;
    border: 2px solid black;
    left: 27.5%;
    top: 27.5%;
}

.pop_up_title{
    margin-top: 2%;
    color: green;
    /* font-size: 200%; */
    font-size: 1.8vw;
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
    font-size: 1.5vw;
}

#pop_up_input{
    margin-top: 5%;
    width: 80%;
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
    font-size: 1.3vw;
    font-weight: bold;
    margin-top: 5%;
}

.pop_up_button:hover {
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
    /* margin-top: 4%; */
    margin-right: 5%;
    background-color: #000000;
}
</style>
