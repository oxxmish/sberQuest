<template>
  <div id="menu" class="menu">
    <input id="template_name" type="text" placeholder="Шаблон комнаты" class="themes_template">
    <div id="first_group_button">
        <div class="master_menu_button" @click="select_question" id="select_question">
            Выбор вопросов
        </div>
        <div class="master_menu_button" @click="select_themes" id="select_themes">
            Выбор тем
        </div>
        <div class="master_menu_button" @click="back_to_templates" >
            К другим шаблонам
        </div>
    </div>
    <div id="second_group_button">
        <div class="master_menu_button" id="save">
            Сохранить
        </div>
        <div class="master_menu_button" >
            Поделиться
        </div>
        <div class="master_menu_button" id="start" @click="create_game">
            Запустить игру
        </div>
    </div>
</div>
</template>

<script>
export default {
  name: 'MasterMenu',
  props: ['template_name'],
  data () {
    return {
    }
  },
  methods: {
    select_question: function () {
      var question = document.getElementById('select_question')
      // eslint-disable-next-line camelcase
      var themes = document.getElementById('select_themes')
      themes.style.opacity = 1
      question.style.opacity = 0.5
      this.$emit('select-question')
    },
    select_themes: function () {
      var question = document.getElementById('select_question')
      // eslint-disable-next-line camelcase
      var themes = document.getElementById('select_themes')
      themes.style.opacity = 0.5
      question.style.opacity = 1
      this.$emit('select-themes')
    },
    create_game: function () {
      this.$emit('create-game')
    },
    back_to_templates: function () {
      this.$emit('back-to-templates')
    },
  },
  mounted: function () {
  this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
    var question = document.getElementById('select_question')
    // eslint-disable-next-line camelcase
    var themes = document.getElementById('select_themes')
    themes.style.opacity = 1
    document.getElementById('select_question').value = question.style.opacity = 0.5
    document.getElementById('template_name').value = this.template_name
    
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.themes_template{
  width: 70%;
  height: 20%;
  text-align: center;
  font-size: 150%;
  border-radius: 10px;
}
.menu{
    float: left;
    width: 20%;
    text-align: center;
    height: 88%;
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
    font-size: 180%;
}

.master_menu_button{
    margin-top: 4%;
    border-radius: 20px;
    padding-top: 4%;
    padding-bottom: 4%;
    margin-left: 10%;
    width: 80%;
    color: white;
    background-color: rgb(38, 146, 17);
    font-size: 120%;
    font-weight: bold;
}

.master_menu_button:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

#first_group_button{
  margin-top: 10%;
}

#second_group_button{
  margin-top: 58%;
}


/* #select_question, #save, #select_themes, #start{
    border-radius: 20px;
    padding-top: 3%;
    padding-bottom: 3%;
    margin-left: 10%;
    width: 80%;
    color: white;
    background-color: rgb(38, 146, 17);
    font-size: 170%;
    font-weight: bold;
    border: black 2px solid;
}
#select_question{
    margin-top: 10%;
}
#select_themes, #start{
    margin-top: 5%;
}
#save{
    margin-top: 75%;
}

#select_question:hover, #save:hover, #select_themes:hover, #start:hover {
    box-shadow: 0 0 10px 100px orange inset;
} */
</style>
