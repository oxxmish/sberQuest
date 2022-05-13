<template>
<div id="lobby_header">Лобби</div>
<div id="group_lobby">
    <div id="player_list">
        <div id="player_list_head">Список игроков</div>
        <hr>
        <!-- <div v-for="(option, index) in users" :key="index" class="wait_users">
            {{option}}
        </div> -->
    </div>
    <div id="group_teams">
        <div class="lobby_team" id="lobby_team_1">
            <div id="lobby_team_head">Команда 1</div>
            <hr>
            <div class="scroll">
                <div id="list_team_1" class="one_player" v-for="(option, index) in team_1" :key="index" :index="index">
                    <input type="text" :value="option" class="wait_users" @blur="save_edit">
                    <div id="delete_player" @click="team_1.pop()">x</div>
                </div>
                <div id="plus_player" @click="team_1.push('Новый игрок')">+</div>
            </div>
        </div>
        <div class="lobby_team" id="lobby_team_2">
            <div id="lobby_team_head">Команда 2</div>
            <hr>
            <div class="scroll">
                <div id="list_team_2" class="one_player" v-for="(option, index) in team_2" :key="index" :index="index">
                    <input type="text"  :value="option" class="wait_users" @blur="save_edit">
                    <div id="delete_player" @click="team_2.pop()">x</div>
                </div>
                <div id="plus_player" @click="team_2.push('Новый игрок')">+</div>
            </div>
        </div>
        <div class="lobby_team" id="lobby_team_3">
            <div id="lobby_team_head">Команда 3</div>
            <hr>
            <div class="scroll">
                <div id="list_team_3" class="one_player" v-for="(option, index) in team_3" :key="index" :index="index">
                    <input type="text"  :value="option" class="wait_users" @blur="save_edit">
                    <div id="delete_player" @click="team_3.pop()">x</div>
                </div>
                <div id="plus_player" @click="team_3.push('Новый игрок')">+</div>
            </div>
        </div>
        <div class="lobby_team" id="lobby_team_4">
            <div id="lobby_team_head">Команда 4</div>
            <hr>
            <div class="scroll">
                <div id="list_team_4" class="one_player" v-for="(option, index) in team_4" :key="index" :index="index">
                    <input type="text"  :value="option" class="wait_users" @blur="save_edit">
                    <div id="delete_player" @click="team_4.pop()">x</div>
                </div>
                <div id="plus_player" @click="team_4.push('Новый игрок')">+</div>
            </div>
        </div>
    </div>
    
    <div id="player_list">
        <div id="player_list_head">Настройки комнаты</div>
        <hr>
        <div id="room_id_header">ID</div>
        <div id="room_id">cc85b209-77e1-47c4-b7dc-fe4cfeb1c35e</div>
        <div id="global_timer_header">Таймер</div>
        <div id="global_timer">
            <input id="timer_hours" maxlength="2" class="clock" type="text" placeholder="00"> 
            <div class="clock_dil">:</div>
            <input id="timer_min" maxlength="2" class="clock" type="text" placeholder="00"> 
            <div class="clock_dil">:</div>
            <input id="timer_sec" maxlength="2" class="clock" type="text" placeholder="00">
        </div>
        <div id="critical_timer_header">Критическая отметка</div>
        <div id="critical_timer">
            <input id="crit_timer_hours" maxlength="2" class="clock" type="text" placeholder="00"> 
            <div class="clock_dil">:</div>
            <input id="crit_timer_min" maxlength="2" class="clock" type="text" placeholder="00"> 
            <div class="clock_dil">:</div>
            <input id="crit_timer_sec" maxlength="2" class="clock" type="text" placeholder="00">
        </div>
        <div id="start_game" @click="start_game">Начать игру</div>
    </div>
</div>
</template>

<script>
export default {
  name: 'AuthWin',
  data(){
    return {
        team_1: [
        ],
        team_2: [
        ],
        team_3: [
        ],
        team_4: [
        ]
    }
  },
  methods: {
        add_player: function (num_team) {
            if(num_team == 'team_1')
                this.team_1.push('Новый игрок');
            else if(num_team == 'team_2')
                this.team_2.push('Новый игрок');
            else if(num_team == 'team_3')
                this.team_3.push('Новый игрок');
            else if(num_team == 'team_4')
                this.team_4.push('Новый игрок');
        },
        save_edit: function (event) {
            if(event.target.parentElement.getAttribute('id') == 'list_team_1')
                this.team_1[event.target.parentElement.getAttribute('index')] = event.target.value;
            else if(event.target.parentElement.getAttribute('id') == 'list_team_2')
                this.team_2[event.target.parentElement.getAttribute('index')] = event.target.value;
            else if(event.target.parentElement.getAttribute('id') == 'list_team_3')
                this.team_3[event.target.parentElement.getAttribute('index')] = event.target.value;
            else if(event.target.parentElement.getAttribute('id') == 'list_team_4')
                this.team_4[event.target.parentElement.getAttribute('index')] = event.target.value;
        },
        start_game: function () {
            console.log(document.getElementById('timer_hours').value);
            this.$emit('start-game', [this.team_1, this.team_2, this.team_3, this.team_4], 
            [document.getElementById('timer_hours').value.length == 0 ? '00' : document.getElementById('timer_hours').value, document.getElementById('timer_min').value.length == 0 ? '00' : document.getElementById('timer_min').value, document.getElementById('timer_sec').value.length == 0 ? '00' : document.getElementById('timer_sec').value], 
            [document.getElementById('crit_timer_hours').value.lenght == 0 ? '00' : document.getElementById('crit_timer_hours').value, document.getElementById('crit_timer_min').value.lenght == 0 ? '00' : document.getElementById('crit_timer_min').value, document.getElementById('crit_timer_sec').value.lenght == 0 ? '00' : document.getElementById('crit_timer_sec').value]);
        },
  },
  mounted: function () {
  this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
    // document.getElementById('tab_1').style.textDecoration = 'underline';
    // this.user_type = 'Master'
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#lobby_header{
    text-align: center;
    /* font-size: 200%; */
    font-size: 2vw;
}

#group_lobby{
    width: 100%;
    height: 98%;
    background: #21A038;
}

#player_list{
    margin-top: 1%;
    margin-left: 2%;
    width: 17.5%;
    height: 95%;
    border: solid black 2px;
    border-radius: 20px;
    float: left;
    background: rgba(255, 255, 255, 0.7);
}

#player_list_head{
    margin-top: 2%;
    text-align: center;
    /* font-size: 130%; */
    font-size: 1.5vw;
}

hr{
    width: 90%;
    color: green;
}

#group_teams{
    margin-left: 1%;
    margin-top: 1%;
    float: left;
    width: 57%;
    height: 95%;
}

.lobby_team{
    border-radius: 20px;
    float: left;
    border: solid black 2px;
    width: 45%;
    height: 46%;
    margin-left: 4%;
    background: rgba(255, 255, 255, 0.7);
}

#lobby_team_head{
    margin-top: 2%;
    text-align: center;
    /* font-size: 130%; */
    font-size: 1.5vw;
}

#lobby_team_3, #lobby_team_4{
    margin-top: 5%;
}

#room_id_header{
    margin-top: 5%;
    text-align: center;
    /* font-size: 150%; */
    font-size: 1.75vw;
    text-decoration: underline;
}

#room_id{
    margin-top: 2%;
    text-align: center;
    /* font-size: 88%; */
    font-size: 0.9vw;
}

#global_timer_header{
    text-align: center;
    margin-top: 5%;
    /* font-size: 150%; */
    font-size: 1.75vw;
    text-decoration: underline;
}

#global_timer{
    width: 80%;
    text-align: center;
    margin-top: 1%;
    /* font-size: 300%; */
    font-size: 3vw;
    height: 10%;
    margin-left: 13%;
}

#critical_timer_header{
    text-align: center;
    margin-top: 5%;
    /* font-size: 150%; */
    font-size: 1.6vw;
    text-decoration: underline;
}

#critical_timer{
    width: 80%;
    text-align: center;
    margin-top: 1%;
    /* font-size: 300%; */
    font-size: 3vw;
    height: 10%;
    margin-left: 13%;
}

#start_game{
    text-align: center;
    width: 80%;
    height: 5%;
    margin-left: 10%;
    border: solid black 2px;
    border-radius: 15px;
    margin-top: 100%;
    /* font-size: 120%; */
    font-size: 1.3vw;
    background: green;
    color: white;
    font-weight: bold;
    line-height: 150%;
}

#start_game:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

.wait_users{
    margin-top: 2%;
    margin-left: 10%;
    width: 75%;
    border: solid black 2px;
    border-radius: 10px;
    text-align: center;
    /* font-size: 120%; */
    font-size: 1.3vw;
    padding-top: 1.5%;
    padding-bottom: 1.5%;
    float: left;
}

.scroll{
    height: 80%;
    overflow: auto;
    -ms-overflow-style: none;
    scrollbar-width: none;
}

.scroll::-webkit-scrollbar {
    width: 0;
    height: 0;
}

#plus_player{
    margin-top: 2%;
    margin-left: 10%;
    width: 80%;
    text-align: center;
    /* font-size: 150%; */
    font-size: 1.5vw;
    font-weight: bold;
    float: left;
}

.one_player{
    width: 100%;
}

#delete_player{
    float: left;
    width: 5%;
    margin-top: 4%;
    margin-left: 2%;
    font-size: 1.3vw;
}

.clock{
    font-size: 100%;
    width: 25%;
    float: left;
    background: rgba(255, 255, 255, 0);
    outline: none;
    border: none;
}

.clock_dil{
    float: left;
}
</style>