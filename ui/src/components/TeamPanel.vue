<template>
  <div id="block" class="block">
    <div v-if="visible==2" class="all_cont">
    <div class="top_item_team">
        <div class="question">
          <img src="@/assets/question.png" alt="Кнопка «button»">
        </div>
        <div v-if="team_number == 'team_1'" class="name_team">Команда 1</div>
        <div v-if="team_number == 'team_2'" class="name_team">Команда 2</div>
        <div v-if="team_number == 'team_3'" class="name_team">Команда 3</div>
        <div v-if="team_number == 'team_4'" class="name_team">Команда 4</div>
        <div class="change_label">
          <button class="button" v-on:click="visible1"><img src="@/assets/menu.png" alt="Кнопка «button»"></button>
        </div>
    </div>
      <div class="center_item_team">
        <div class="column_prompt_1">
            <div class="prompt_1">
            <button class="button"><img src="@/assets/replace_f.png" alt="Кнопка «button»"></button>
            </div>
            <div class="prompt_1">
            <button class="button"><img src="@/assets/help_player.png" alt="Кнопка «button»"></button>
            </div>
        </div>
        <div class="column_img">
            <img v-if="team_number == 'team_1'" id="logo" src="@/assets/team_logo_1.png">
            <img v-if="team_number == 'team_2'" id="logo" src="@/assets/team_logo_2.png">
            <img v-if="team_number == 'team_3'" id="logo" src="@/assets/team_logo_3.png">
            <img v-if="team_number == 'team_4'" id="logo" src="@/assets/team_logo_4.png">
        </div>
        <div class="column_prompt_2">
            <div class="prompt_1">
            <button class="button"><img src="@/assets/replace_q.png" alt="Кнопка «button»"></button>
            </div>
            <div class="prompt_1">
            <button class="button"><img src="@/assets/help_master.png" alt="Кнопка «button»"></button>
            </div>
        </div>
      </div>
      <div class="bottom_item_team">
        <div class="themes1">
            <div v-for="(item, index) in themes_sber" class="themes4" :style="item.color+item.font" :key="index">
            </div>
        </div>
        <div  class="button_themes">
          <button id="dots_parent" class="button" v-on:click="visible3"><img id="dots" src="@/assets/dots.png" alt="Кнопка «button»"></button>
        </div>
      </div>
      <div class="footer_item_team">
        <div class="points_1">
            Баллы:
          </div>
          <div class="points_2">
            {{score}}
          </div>
          <div class="puzzle_1">
            Пазлы:
          </div>
          <div class="puzzle_2">
            {{puzzle}}
          </div>
          <div class="puzzle_3">
            /
          </div>
          <div class="puzzle_4">
            16
          </div>
      </div>
    </div>
    <div v-else-if="visible==1" class="all_cont">
      <div class="top_item_team">
        <div class="question">
          <img src="@/assets/question.png" alt="Кнопка «button»">
        </div>
        <div class="name_team">
          Состав команды
        </div>
        <div class="change_label">
          <button class="button" v-on:click="visible2"><img src="@/assets/menu.png" alt="Кнопка «button»"></button>
        </div>
      </div>
      <!-- <table>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
          <tr>
              <td>1</td><td>2</td>
          </tr>
      </table> -->
      <div class="table1">
        <div class="tr1">
          <div class="td1" id="list_1">
          </div>
          <div class="td2" id="list_2">
          </div>
        </div>
        <div class="tr1">
          <div class="td1" id="list_3">
          </div>
          <div class="td2" id="list_4">
          </div>
        </div>
        <div class="tr1">
          <div class="td1" id="list_5">
          </div>
          <div class="td2" id="list_6">
          </div>
        </div>
        <div class="tr1">
          <div class="td1" id="list_7">
          </div>
          <div class="td2" id="list_8">
          </div>
        </div>
        <div class="tr1">
          <div class="td1" id="list_9">
          </div>
          <div class="td2" id="list_10">
          </div>
        </div>
        <div class="tr2">
          <div class="td1" id="list_11">
          </div>
          <div class="td2" id="list_12">
          </div>
        </div>
      </div>
    </div>
    <div v-else class="all_cont">
      <div class="top_item_team">
        <div class="question">
          <!-- <img src="@/assets/free-icon-question-2476199 4.png" alt="Кнопка «button»"> -->
        </div>
        <div v-if="team_number == 'team_1'" class="name_team">Команда 1</div>
        <div v-if="team_number == 'team_2'" class="name_team">Команда 2</div>
        <div v-if="team_number == 'team_3'" class="name_team">Команда 3</div>
        <div v-if="team_number == 'team_4'" class="name_team">Команда 4</div>
        <div class="change_label">
          <button class="button" v-on:click="visible2"><img src="@/assets/menu.png" alt="Кнопка «button»"></button>
        </div>
      </div>
      <div class="themes2">
        <div v-for="(item, index) in themes_sber" class="themes3" :style="item.color+item.font" :key="index">
          {{ item.product }}
        </div>
      </div>
      <div class="button_themes2">
          <button id="dots_parent" class="button" v-on:click="visible2"><img id="dots" src="@/assets/dots.png" alt="Кнопка «button»"></button>
      </div>
      <div class="footer_item_team">
        <div class="points_1">
            Баллы:
          </div>
          <div class="points_2">
            {{score}}
          </div>
          <div class="puzzle_1">
            Пазлы:
          </div>
          <div class="puzzle_2">
            {{puzzle}}
          </div>
          <div class="puzzle_3">
            /
          </div>
          <div class="puzzle_4">
            16
          </div>
      </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'TeamPanel',
  props:['team_number', 'puzzle', 'score'],
  data: function () {
    return {
      visible: 2,
      themes_sber: [
          {product:'СберЗвук', color:'background:white;', font:'line-height:200%;'},
          {product:'РаботаРу', color:'background:white;', font:'line-height:200%;'},
          {product:'Окко', color:'background:white;', font:'line-height:200%;'}, 
          {product:'СберДиск', color:'background:white;', font:'line-height:200%;'}, 
          {product:'СберБокс', color:'background:white;', font:'line-height:200%;'}, 
          {product:'СберМаркет', color:'background:white;', font:'font-size:78%;line-height:250%;'}, 
          {product:'ДеливериКлаб', color:'background:white;', font:'font-size:65%;line-height:310%;'}, 
          {product:'Самокат', color:'background:white;', font:'line-height:200%;'}, 
          {product:'СитиМобил', color:'background:white;', font:'font-size:82%;line-height:240%;'}, 
          {product:'СберПрайм', color:'background:white;', font:'font-size:86%;line-height:230%;'}, 
          {product:'СберПрайм+', color:'background:white;', font:'font-size:75%;line-height:250%;'}, 
          {product:'СберМобайл', color:'background:white;', font:'font-size:78%;line-height:250%;'}, 
          {product:'СберЕАптека', color:'background:white;', font:'font-size:72%;line-height:280%;'}, 
          {product:'ДомКлик', color:'background:white;', font:'line-height:200%;'}, 
          {product:'СберЗдоровье', color:'background:white;', font:'font-size:70%;line-height:290%;'}, 
          {product:'СберМегаМаркет', color:'background:white;', font:'font-size:56%;line-height:360%;'},
          ],
    }
  },
  methods: {
    // visible1 () { this.visible = 1 },
    visible2 () { this.visible = 2;  },
    visible3 () { this.visible = 3;  },
    action(product, color) {
      for(var i = 0; i < this.themes_sber.length; ++i)
      {
          if(this.themes_sber[i].product == product)
              this.themes_sber[i].color = color;
      }
      }
  }
}
</script>

<style scoped>
.themes4{
  margin-top: 4%;
  margin-left: 6%;
  width: 5%;
  height: 20%;
  float: left ;
  background-color: white;
  border: solid 2px black;
  border-radius: 100%;
}
.themes3{
  margin-top: 2%;
  margin-left: 3%;
  width: 20%;
  height: 20%;
  border: 1px solid black;
  float: left ;
  color: black;
  border-radius: 15%;
  text-align: center;
}
.button_themes2{
  width: 10%;
height: 15%;

  align-content: center;
  float: left ;
  margin-top: 20% ;
}
.themes2{
  width: 90%;
  height: 90%;

  float: left ;
}
.button_themes{
  width: 10%;
  height: 50%;
  float: left ;
  margin-top: 4.5% ;
}
.themes1{
  width: 90%;
  height: 100%;

  float: left ;
}
.table1{
  width: 100%;
  height: 100%;

}
.tr1{
  width: 80%;
  height: 15%;
  border-bottom: 2px solid black;
  margin-left: auto;
  margin-right: auto;
}
.tr2{
  width: 80%;
  height: 15%;
  margin-left: auto;
  margin-right: auto;
}
.td1{
  width: 48%;
  height: 90%;
  border-right: 2px solid black;
  float: left ;
}
.td2{
  width: 48%;
  height: 90%;
  margin-left: 1%;
  float: left ;
}
.block{
  width: 25%;
  height: 35%;
  background: rgba(76, 28, 214, 0.35);
  border-radius: 25px;
  position: absolute;
}
.all_cont{
  margin-top: 2%;
  width: 100%;
  height: 80%;
}
.top_item_team{
  width: 90%;
  height: 17%;
  margin-left: 8%;
}
.question{
  width: 15%;
  height: 90%;
  float: left ;
  margin-top: 2%;
}
.button{
  margin-top: 10%;
  margin-left: 10%;
}
.name_team{
  width: 54%;
  height: 70%;
  text-align:  center;
  margin-top: 3%;
  float: left ;
  font-size: 160%;
  color: black;
  margin-left: 4%;

}
.change_label{
  width: 20%;
  height: 90%;
  margin-left: 5%;
  float: left ;
}
.center_item_team{
  width: 100%;
  height: 50%;
  margin-top: 5%;
  margin-left: 8%;
}
.column_prompt_1{
  width: 20%;
  height: 95%;

  float: left ;
  margin-left: 2%;
}
.column_prompt_2{
  width: 20%;
  height: 95%;

  float: left ;
  margin-left: 5%;
}
.column_img{
  width: 30%;
height: 95%;
float: left;
margin-right: 5%;
border: solid;
border-radius: 50%;
margin-left: 5%;
background: white;
}
.prompt_1{
  width: 100%;
  height: 45%;

  float: left ;
}
.bottom_item_team{
  width: 100%;
  height: 28%;
  margin-left: auto;
  margin-right: auto;
}
.footer_item_team{
  width: 100%;
  height: 15%;
  margin-top: 2.5%;
  margin-left: 4%;
  margin-right: auto;
}
.points_1{
  width: 20%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
  margin-left: 5%;
}
.points_2{
  width: 5%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
}
.puzzle_1{
  width: 20%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
  margin-left: 25%;
}
.puzzle_2{
  width: 3%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
}
.puzzle_3{
  width: 1%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
}
.puzzle_4{
  width: 1%;
  height: 95%;

  float: left ;
  font-size: 20px;
  color: black;
}

button{
background-color:transparent;
border: none;
}

#dots{
    height: 100%;
    width: 100%;
}

#dots_parent{
    margin-top: 0;
    margin-left: 0;
    height: 100%;
    width: 100%;
}

#logo{
    margin-top: 14%;
margin-left: 22%;
}

table{
    margin-top: 5%;
width: 90%;
margin-left: 5%;
}
td{
    border: solid;
}
</style>
