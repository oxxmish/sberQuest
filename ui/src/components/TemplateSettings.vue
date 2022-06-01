<template>
<!-- <MasterMenu @select-question= "visible1" @select-themes= "visible2"  /> -->
<div v-if="visible==1" class="item_block_scroll">
      <div v-for="(product,index) in products" :key="index" id="size_themes">
        <div class="themes_themes" :style="get_color(product)" >
            <div class="text_themes" >
              {{product.name}}
            </div>
            <button class="button_themes" v-on:click="product.visible_question=!product.visible_question"><img class="polygon" src="@/assets/Polygon_1.png" @click="rotate"></button>
        </div>
        <div v-for="(question,index) in product.questions" :key="index" class="quest_themes"  v-show="product.visible_question">
            <div class="name_quest2">
              {{question.shortText}}
            </div>
            <div class="type_quest">
              {{get_readiable_type(question.questionType)}}
            </div>
            <div class="check_quest">
                <input class="check_quest_2" type="checkbox" :checked="question.Need_quest" v-on:click="question.Need_quest= !question.Need_quest">
            </div>
        </div>
      </div>
</div>
<div v-if="visible==2" class="item_block">
  <div class="count_field">
      <div class="text_fields">
        Число игровых полей
      </div>
        <form style="height:85%">
          <div class="radio_text">
          <input type="radio" id="Choice1" class="radio_fields" checked
          name="Fields_Count" v-on:click="count_field_16">
          <label>16</label>

          <input type="radio" id="Choice2" class="radio_fields"
          name="Fields_Count" v-on:click="count_field_20">
          <label>20</label>

          <input type="radio" id="Choice3" class="radio_fields"
          name="Fields_Count" v-on:click="count_field_24">
          <label >24</label>
          </div>
        </form>
  </div>
  <div class="count_field">
      <div class="text_fields">
        Количество выбранных полей
      </div>
      <label class="fields_number_progressbar">0</label>
      <div class="progressbar">
        <span class="progress_1" id="progress_1"></span>
      </div>
      <label id="total_field" class="fields_number_progressbar">{{calc_sum_field()}} из {{count_field}}</label>
  </div>
  <div class="tex_themes_before">
    Укажите количество повторений темы на игровом поле
  </div>
  <div class="item_block_scroll_2" >
      <div class="block_all_themes_filed" >
        <div v-for="(product,index) in products.filter(option => option.name != 'Финал' && option.name != 'Полуфинал')" :key="index" id="size_themes_2" >
              <div class="themes_themes_2" :style="product.colour">
                  <div class="text_fields_themes" >
                    {{product.name}}
                  </div>
                  <form style="height:100%;">
                    <div class="radio_text_2">
                      <div v-for="(r_butt,index) in radio_buttons" :key="index" style="height:100%;float:left;width:10%">
                          <input type="radio" class="radio_fields_2" name="Fields_Count" v-on:click="product.count = r_butt, product.current_checked = index, count_field_now()" style="float:left;" :checked="product.current_checked == index">
                          <label style="float:left;margin-top:1%;">{{r_butt}}</label>
                      </div>
                    </div>
                  </form>
              </div>
        </div>
      </div>
  </div>
</div>
</template>

<script>
//import MasterMenu from './MasterMenu.vue'

export default {
  name: 'TemplateSettings',
  props: ['visible', 'id'],
  data () {
    return {
      // visible: 1,
      name_template: '',
      count_field: 16,
      count_field_now_pole: 1,
      progress: 0,
      radio_buttons: [
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9
      ],
      current_template: {},
      products: [],
      template_products: []
    }
  },
  methods: {
    calc_sum_field: function () { 
      let tmp = 0;
      for (let field = 0; field < this.products.length; ++field) 
      {
        console.log(this.products[field].count)
        tmp = tmp + this.products[field].count;
      }
      
      if(document.getElementById('total_field') && tmp > this.count_field)
        document.getElementById('total_field').style.color = 'red';
      else if(document.getElementById('total_field'))
        document.getElementById('total_field').style.color = 'white';
      return tmp;
    },
    count_field_16: function () { 
      this.count_field = 16;
      this.$emit('change-count', this.count_field);
      this.count_field_now();
      console.log(this.products);
    },
    count_field_20: function () { // смена количества полей в игре на 20
      this.count_field = 20;
      this.$emit('change-count', this.count_field);
      this.count_field_now();
    },
    count_field_24: function () { // смена количества полей в игре на 24
      this.count_field = 24;
      this.$emit('change-count', this.count_field);
      this.count_field_now();
    },
    count_field_now: function () { // подсчет текущего количества выбранных полей
      this.count_field_now_pole = 0
      for (var field = 0; field < this.products.length; field++) {
        this.count_field_now_pole = this.count_field_now_pole + this.products[field].count
      }
      this.progress_bar()
    },
    progress_bar: function () { // обновление прогресс бара
      this.progress = this.count_field_now_pole / this.count_field * 100
      if (this.progress > 100) this.progress = 100
      this.progress = String(this.progress) + '%'
      document.getElementById('progress_1').style = 'width:' + this.progress
    },
    rotate: function (event) {
    console.log(event.target.style);
      if(event.target.style.transform == 'rotate(180deg)')
        event.target.style = 'transform:rotate(0deg);';
      else
        event.target.style = 'transform:rotate(180deg);';
    },
    get_readiable_type: function (type) {
      let mapping = new Map();
      mapping.set("TEXT", "Без выбора ответа").set("AUCTION", "Вопрос-аукцион").set("TEXT_WITH_ANSWERS", "С выбором ответа").set("MEDIA", "Вопрос с медиа фрагментом");
      return mapping.get(type);
    },
    get_color: function (product) {
      if(product.name == "Финал" || product.name == "Полуфинал")
        return "background-color:#bebebe;color:black;"
      else
        return product.colour;
    },
    save_template_product: function (data) {
      this.current_template = data;
      this.template_products = this.current_template.products;
      console.log("Template");
      console.log(this.template_products);
      fetch("http://api.vm-96694bec.na4u.ru/product/getAll", {
              method: "GET",
              headers: {'Content-Type': 'application/json'}
              }).then( res => res.json() ).then( data => this.save_all_product(data) );
    },
    save_all_product: function (data) {
      // this.current_template = data;
      this.products = data;
      if(!this.id)
      {
        this.products.forEach(element => {
          if(element.name == 'Финал' || element.name == 'Полуфинал')
          {
            element.current_checked = 0;
            element.count = 0;
          }
          else
          {
            element.current_checked = 1;
            element.count = 1;
          }
          element.visible_question = true;
          element.questions.forEach( question => {
            question.Need_quest = false;
          });
        });
      }
      else
      {
        console.log("else");
        console.log(this.products);
        console.log(this.template_products);
        this.products.forEach(element => {
          element.visible_question = false;
          element.current_checked = 0;
          element.count = 0;
          element.questions.forEach( question => {
            question.Need_quest = false;
          });
          this.template_products.forEach(template_element => { 
            if( template_element.id == element.id )
            {
              element.current_checked = template_element.numOfRepeating;
              element.count = template_element.numOfRepeating;
              element.questions.forEach( question => {
                template_element.questions.forEach( template_question => {
                    if(question.id == template_question.id)
                      question.Need_quest = true;
                 });
              });
            }
          });
        });
      }
    },
    get_product: function () {
      let result = [];
      this.products.forEach(element => {
        let cur_id = element.id;
        let cur_count = element.count;
        let cur_qs = [];
        element.questions.forEach( question => {
            if(question.Need_quest)
              cur_qs.push(question.id);
          });
        result.push({productId: cur_id, numberOfRepeating: cur_count, questionIds: cur_qs});
      });
      return result;
    },
  },
  mounted: function () {
      // var template_ref;
      let products_ref = this.products;
      products_ref.length = 0;
      let id = this.id;
      console.log("Check");
      if(id)
        fetch("http://api.vm-96694bec.na4u.ru/board/get/" + String(id), {
              method: "GET",
              headers: {'Content-Type': 'application/json'}
              }).then( res => res.json() ).then( data => this.save_template_product(data) );
      else
        fetch("http://api.vm-96694bec.na4u.ru/product/getAll", {
              method: "GET",
              headers: {'Content-Type': 'application/json'}
              }).then( res => res.json() ).then( data => this.save_all_product(data) );
      // console.log(template_ref);
    this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
      this.count_field_now();
    })
  },
  updated: function () {
    this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
      this.count_field_now();
    })
  }
}
</script>

<style scoped>
.radio_text_2{
width: 68%;
height: 80%;
float: left;
/* font-size: 250%; */
font-size: 2vw;
margin-top: 0.7%;
color: white;
}
.radio_text{
width: 50%;
height: 60%;
float: left;
/* font-size: 150%; */
font-size: 2vw;
margin-top: 0.3%;
}
.button_themes{
float: left;
width: 5%;
height: 60%;
margin-left: 31.5%;
margin-top: 1%;
background-color:transparent;
border: none;
}
.text_themes{
float: left;
width: 30%;
height: 70%;
/* font-size: 200%; */
font-size: 2vw;
/* color:#ffffff; */
margin-left: 30%;
margin-top: 1%;
text-align: center;
}

 input:checked {
  border: 3px solid white;
  background: green;
}

.radio_fields_2{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  margin-left:1% ;
  border-radius: 50%;
  width: 50%;
  height: 70%;
  background: white;
  border: 2px solid #999;
  transition: 0.2s all linear;
  outline: none;
  margin-right: 5px;
  margin-top: 1% ;
  position: relative;
  top: 4px;
}
.text_fields_themes{
 float: left;
 margin-top: 1.2%;
 width: 30%;
 height: 40%;
 text-align: center;
 /* font-size: 250%; */
 font-size: 2vw;
 color: white;
}
.block_all_themes_filed{
   width: 99%;
   height: 70%;
  float: left;
}
#size_themes_2{
   float: left;
    height: 20%;
    width: 100%;
    margin-top: 0.7%;
}
.themes_themes_2{
   float: left;
   width: 100%;
   height: 100%;
   background-color: rgb(38, 146, 17);
   border-radius: 15px;
   border: solid 2.5px black;
}
.themes_themes{
   float: left;
   width: 98%;
   height: 100%;
   background-color: rgb(38, 146, 17);
   border-radius: 15px;
   border: solid 2.5px black;
}
.fields_number_progressbar{
   float: left;
   margin-right: 1%;
   margin-left: 1%;
   margin-top: 1%;
   font-size: 2vw;
}
.progressbar > span {
  border-radius: 15px;
  display: block;
  height: 100%;
  background-color: rgb(255,255,255);
  color: black;
  text-align: right;
  margin-right: 5%;
}
.progressbar {
  border-radius: 15px;
  margin-top: 1.5%;
  float: left;
  width: 40%;
  height: 40%;
  position: relative;
  background: rgba(255, 255, 255, 0.6);
}
.radio_fields{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;

  margin-left:6% ;
  border-radius: 50%;
  width: 7%;
  height: 100%;
  background: white;
  border: 2px solid #999;
  transition: 0.2s all linear;
  outline: none;
  margin-right: 5px;
  margin-top: 1% ;
  position: relative;
  top: 4px;
}
.tex_themes_before{
    height: 8%;
    width: 98%;
    float: left;
    text-align: center;
    font-size: 2vw;
    margin-top: 0.7%;
}
#size_themes{
    height: 10%;
    width: 100%;
    margin-top: 0.7%;
}
.item_block_scroll::-webkit-scrollbar {
    width: 0;
    height: 0;
}
.item_block_scroll_2::-webkit-scrollbar {
    width: 0;
    height: 0;
}
.item_block_scroll{
    height: 90%;
    width: 78%;
    float: left;
    overflow: auto;
    -ms-overflow-style: none;
    scrollbar-width: none;
}
.item_block_scroll_2{
    height: 70%;
    width: 100%;
    float: left;
    overflow: auto;
    -ms-overflow-style: none;
    scrollbar-width: none;
}
.item_block{
    height: 90%;
    width: 78%;
    float: left;
}
.text_fields{
margin-top: 1% ;
margin-left:2% ;
 height: 70%;
 width: 40%;
 float: left;
 font-size: 1.7vw;
}
.count_field{
margin-top: 0.5%;
height: 10%;
width: 99%;
float: left;
background-color: rgba(33, 160, 56, 1);
border-radius: 15px;
border: 2.5px solid black;
color: #ffffff;
font-size: 30px;
text-align: center;

}

.app{
height: 100%;
width: 100%;
}

.name_quest2{
float: left;
height: 90%;
width: 30%;
font-size: 1.6vw;
margin-top: 0.5%;
margin-left: 5%;
}
.type_quest{
float: left;
height: 90%;
width: 30%;
margin-left: 15%;
font-size: 1.6vw;
margin-top: 0.5%;
}
.check_quest{
float: left;
height: 90%;
width: 10%;
margin-left: 5%;
margin-top: 0.3%;
}
.check_quest_2{
float: left;
height: 90%;
width: 90%;
margin-top: 0.5%;
margin-left: 45%;
border-radius: 25%;
}
.quest_themes{
    float: left;
    border: 2px solid black;
    width: 98%;
    height: 70%;
    background-color: rgb(255, 255, 255);
    border-radius: 12px;
    font-size: 20px;
}

html {
    height: 100%;
    width: 100%;
}

body {
    width: 99%;
    height: 95%;
}
#app{
  height: 100%;
    width: 100%;
}
.telo {
    width: 99%;
    height: 90%;
    background: rgb(33, 160, 56);
}
.block_quest {
    width: 50%;
    height: 100%;
    float: left ;
}
.block_param {
    width: 49%;
    height: 100%;
    float: left ;
}
.block_background{
    width: 95%;
    height: 95%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    border-radius: 5%;
    margin-top: 2%;
    margin-left: 2%;
}
.block_background_2{
    width: 95%;
    height: 25%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    margin-top: 2%;
    margin-left: 2%;
    border-radius: 25px;
}
.block_background_3{
    width: 95%;
    height: 33%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    margin-top: 2%;
    margin-left: 2%;
    border-radius: 25px;
}
.name_quest {
    width: 95%;
    height: 15%;
    float: left ;
    border-bottom: 2px solid green;
    text-align: center;
    margin-left: 2%;
    font-size: 24px;
    margin-top: 2%;
}
.telo_quest {
    width: 99%;
    height: 80%;
    float: left ;
    text-align: center;
    font-size: 24px;
    vertical-align:auto;
}
.name_answer {
    width: 95%;
    height: 25%;
    float: left ;
    border-bottom: 2px solid green;
    text-align: center;
    margin-left: 2%;
    font-size: 20px;
    margin-top: 2%;
}
.telo_answer {
    width: 99%;
    height: 60%;
    float: left ;
    text-align: center;
    font-size: 20px;
    vertical-align:auto;
}

.menu_left{
    float: left;
    width: 20%;
    text-align: center;
    height: 94%;
    padding-top: 1%;
    padding-bottom: 1%;
    border-right: 2px solid silver;
    margin-right: 1%;
}

.avatar{
    margin-left: 15%;
    width: 70%;
    color: #ffffff;
    padding-top: 15%;
    padding-bottom: 15%;
    border-radius: 20px;
    border: solid black 2px;
    /* font-size: 180%; */
    font-size: 1.8vw;
}

#edit, #back, #delete{
    border-radius: 20px;
    padding-top: 4%;
    padding-bottom: 4%;
    margin-left: 10%;
    width: 80%;
    color: white;
    background-color: green;
    /* font-size: 120%; */
    font-size: 1.2vw;
    font-weight: bold;
}
#edit{
    margin-top: 10%;
}
#delete{
    margin-top: 5%;
}
#back{
    margin-top: 100%;
}

#edit:hover, #back:hover, #delete:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

.polygon{
  height: 80%;
  width: 70%;
}
</style>
