<template>
    <TeamPanel ref="team_1" id="team_1" :team_number="'team_1'" :puzzle="puzzles[0]" :score="scores[0]" />
    <TeamPanel ref="team_2" id="team_2" :team_number="'team_2'" :style="'background:rgba(214, 28, 28, 0.68);'" :puzzle="puzzles[1]" :score="scores[1]" />
    <TeamPanel ref="team_3" id="team_3" :team_number="'team_3'" :style="'background:rgba(28, 180, 214, 0.35);'" :puzzle="puzzles[2]" :score="scores[2]" />
    <TeamPanel ref="team_4" id="team_4" :team_number="'team_4'" :style="'background:rgba(117, 205, 6, 0.65);'" :puzzle="puzzles[3]" :score="scores[3]" />
    <GameField @set-question="set_question" @next-round="next_round" ref="MainField" />
    <PopUpQuestion :tour="tour" :question='current_question' @give-puzzle="give_puzzle" @give-score="give_score" />
</template>

<script>
import TeamPanel from './components/TeamPanel.vue'
import GameField from './components/GameField.vue'
import PopUpQuestion from './components/PopUpQuestion.vue'

export default {
  name: 'ManageMasters',
  data(){
    return {
      current_question: ['Для получения вопроса бросьте кубик', 'Тип вопроса', 'Название продукта'],
      puzzles: [ 0, 0, 0, 0 ],
      scores: [ 0, 0, 0, 0 ],
      tour: 1,
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
    set_question: function (question) {
      this.current_question = question;
    },
    give_puzzle: function (team, product) {
      if(team == 'team_1')
      {
        this.$refs.team_1.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[0];
      }
        
      if(team == 'team_2')
      {
        this.$refs.team_2.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[1];
      }
      if(team == 'team_3')
      {
        this.$refs.team_3.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[2];
      }
      if(team == 'team_4')
      {
        this.$refs.team_4.action(product, this.$refs.MainField.get_color(product));
        ++this.puzzles[3];
      }
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
  }
}
</script>

<style>

</style>
