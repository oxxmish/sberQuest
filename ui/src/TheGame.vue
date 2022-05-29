<template>
    <TeamPanel ref="team_1" id="team_1" :players="teams ? teams[0] : []" :team_number="'team_1'" :puzzle="puzzles[0]" :score="scores[0]" />
    <TeamPanel ref="team_2" id="team_2" :players="teams ? teams[1] : []" :team_number="'team_2'" :style="'background:rgba(214, 28, 28, 0.68);'" :puzzle="puzzles[1]" :score="scores[1]" />
    <TeamPanel ref="team_3" id="team_3" :players="teams ? teams[2] : []" :team_number="'team_3'" :style="'background:rgba(28, 180, 214, 0.35);'" :puzzle="puzzles[2]" :score="scores[2]" />
    <TeamPanel ref="team_4" id="team_4" :players="teams ? teams[3] : []" :team_number="'team_4'" :style="'background:rgba(117, 205, 6, 0.65);'" :puzzle="puzzles[3]" :score="scores[3]" />
    <GameField :timer="timer ? timer : ['00', '00', '00']" :crit_timer="crit_timer ? crit_timer : ['00', '00', '00']" :tmpl_id="tmpl_id" :state="state" @set-question="set_question" @next-round="next_round" @set-config="set_config" ref="MainField" />
    <PopUpQuestion :turn="turn" :second_turn="second_turn" :tour="tour" :question='current_question' @give-puzzle="give_puzzle" @give-score="give_score" />
</template>

<script>
import TeamPanel from './components/TeamPanel.vue'
import GameField from './components/GameField.vue'
import PopUpQuestion from './components/PopUpQuestion.vue'

export default {
  name: 'ManageMasters',
  props:['teams', 'timer', 'crit_timer', 'tmpl_id'],
  data(){
    return {
      state: {},
      current_question: ['Для получения вопроса бросьте кубик', 'Тип вопроса', 'Название продукта'],
      puzzles: [ 0, 0, 0, 0 ],
      scores: [ 0, 0, 0, 0 ],
      tour: 1,
      turn: -1,
      second_turn: -1,
      // teams: null, 
      products: [
        { text: '1', value: '1', color:"color:black;font-size:500%;", 
          questions:[
            { id: '1', text: 'Вопрос 1', type: 'С выбором ответа', wording: 'Какой-то вопрос 1' }, 
            { id: '2', text: 'Вопрос 2', type: 'Без выбора ответа', wording: 'Какой-то вопрос 2' }, 
            { id: '3', text: 'Вопрос 3', type: 'Вопрос-аукцион', wording: 'Какой-то вопрос 3' }, 
            { id: '4', text: 'Вопрос 4', type: 'Вопрос с медиа фрагментом', wording: 'Какой-то вопрос 4' },
            ] 
        },
        { text: '2', value: '2', color:"color:black;font-size:500%;", 
          questions:[
            { id: '1', text: 'Вопрос 1', type: 'С выбором ответа', wording: 'Какой-то вопрос 5' }, 
            { id: '2', text: 'Вопрос 2', type: 'Без выбора ответа', wording: 'Какой-то вопрос 6' }, 
            { id: '3', text: 'Вопрос 3', type: 'Вопрос-аукцион', wording: 'Какой-то вопрос 7' }, 
            { id: '4', text: 'Вопрос 4', type: 'Вопрос с медиа фрагментом', wording: 'Какой-то вопрос 8' },
            ]  
        },
        { text: 'СберАптека', value: '3', color:"color:white;background:red", 
          questions:[
            { id: '1', text: 'Вопрос 1', type: 'С выбором ответа', wording: 'Какой-то вопрос 1' }, 
            { id: '2', text: 'Вопрос 2', type: 'Без выбора ответа', wording: 'Какой-то вопрос 2' }, 
            { id: '3', text: 'Вопрос 3', type: 'Вопрос-аукцион', wording: 'Какой-то вопрос 3' }, 
            { id: '4', text: 'Вопрос 4', type: 'Вопрос с медиа фрагментом', wording: 'Какой-то вопрос 4' },
            ] 
        },
        { text: 'ДомКлик', value: '4', color:"color:white;background:purple", 
          questions:[
            { id: '1', text: 'Вопрос 1', type: 'С выбором ответа', wording: 'Какой-то вопрос 5' }, 
            { id: '2', text: 'Вопрос 2', type: 'Без выбора ответа', wording: 'Какой-то вопрос 6' }, 
            { id: '3', text: 'Вопрос 3', type: 'Вопрос-аукцион', wording: 'Какой-то вопрос 7' }, 
            { id: '4', text: 'Вопрос 4', type: 'Вопрос с медиа фрагментом', wording: 'Какой-то вопрос 8' },
            ]  
        },
      ]
    }
  },
  components: {
    TeamPanel,
    GameField,
    PopUpQuestion
  }, 
  methods: {
    set_question: function (question, turn) {
      this.current_question = question;
      this.turn = turn;
    },
    give_puzzle: function (team, product) {
      if(team == 'team_1')
      {
        if(this.$refs.team_1.check_color(product) != 'background:white;')
          return;
        this.$refs.team_1.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[0];
      }
        
      if(team == 'team_2')
      {
        if(this.$refs.team_2.check_color(product) != 'background:white;')
          return;
        this.$refs.team_2.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[1];
      }
      if(team == 'team_3')
      {
        if(this.$refs.team_3.check_color(product) != 'background:white;')
          return;
        this.$refs.team_3.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[2];
      }
      if(team == 'team_4')
      {
        if(this.$refs.team_4.check_color(product) != 'background:white;')
          return;
        this.$refs.team_4.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[3];
      }
      this.state.puzzles = this.puzzles;
      fetch("http://api.vm-96694bec.na4u.ru/game/chooseQuestion", {
                  method: "POST",
                  headers: {'Content-Type': 'application/json'},
                  body: JSON.stringify({questionId:1, questionType:"REGULAR", state:JSON.stringify(this.state)})
                  });
    },
    give_score: function (team, score) {
      if(team == 'team_1')
      {
        this.scores[0] += Number(score);
      }
        
      if(team == 'team_2')
      {
        this.scores[1] += Number(score);
      }
      if(team == 'team_3')
      {
        this.scores[2] += Number(score);
      }
      if(team == 'team_4')
      {
        this.scores[3] += Number(score);
      }
    },
    next_round: function () {
        this.tour = 2;
    },
    save_state: function (data) {
        if(data.state != 'game_begin')
        {
          this.state = JSON.parse(data.state);
          this.$refs.MainField.set_db_config(this.state.field_config);
        }
        else
          this.state = data.state;
        console.log(this.state);
    },
    set_config: function (config) {
        this.state.field_config = config;
        fetch("http://api.vm-96694bec.na4u.ru/game/chooseQuestion", {
                  method: "POST",
                  headers: {'Content-Type': 'application/json'},
                  body: JSON.stringify({questionId:1, questionType:"REGULAR", state:JSON.stringify(this.state)})
                  });
    },
  },
  mounted: function () {
  this.$nextTick(function () {
    fetch("http://api.vm-96694bec.na4u.ru/game/getAnswer", {
              method: "GET",
              headers: {'Content-Type': 'application/json'}
              }).then( res => res.json() ).then( data => this.save_state(data) );

    if(this.state == 'game_begin')
    {
      this.state.puzzles = this.puzzles;
      this.state.scores = this.scores;
      this.state.teams = this.teams;
      this.state.timer = this.timer;
      this.state.crit_timer = this.crit_timer;
      this.state.tmpl_id = this.tmpl_id;
      fetch("http://api.vm-96694bec.na4u.ru/game/chooseQuestion", {
                  method: "POST",
                  headers: {'Content-Type': 'application/json'},
                  body: JSON.stringify({questionId:1, questionType:"REGULAR", state:JSON.stringify(this.state)})
                  });
    }
  })
  }
}
</script>

<style scoped>

#team_1{
  position: absolute;
  left: 1%;
}

#team_2{
  position: absolute;
  left: 74%;
}

#team_3{
  position: absolute;
  left: 1%;
  top: 63%;
}

#team_4{
  position: absolute;
   top: 63%;
  left: 74%;
}

</style>
