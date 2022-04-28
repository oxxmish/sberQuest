<template>
     <div id="menu" class="menu">
        <input type="text" placeholder="Шаблон комнаты" class="themes_template">
        <div @click="select_question" id="select_question">
            Выбор вопросов
        </div>
        <div @click="select_themes" id="select_themes">
            Выбор тем
        </div>
        <div id="save">
            Сохранить
        </div>
        <div id="start"  @click="create_game">
            Запустить игру
        </div>
    </div>
</template>

<script>
export default {
  name: 'MasterMenu',
  data () {
    return {
    }
  },
  methods: {
    select_question: function () {
      var edit = document.getElementById('select_question')
      // eslint-disable-next-line camelcase
      var click_delete = document.getElementById('select_themes')
      click_delete.style.opacity = 0.5
      edit.style.opacity = 1
      this.$emit('select-question')
    },
    select_themes: function () {
      var edit = document.getElementById('select_question')
      // eslint-disable-next-line camelcase
      var click_delete = document.getElementById('select_themes')
      click_delete.style.opacity = 1
      edit.style.opacity = 0.5
      this.$emit('select-themes')
    },
    create_game: function () {
      this.$emit('create-game')
    }
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

#select_question, #save, #select_themes, #start{
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
}
</style>
