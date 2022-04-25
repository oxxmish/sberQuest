<template>
<div id="lobby_header">Лобби</div>
<div id="group_lobby">
    <div id="player_list">
        <div id="player_list_head">Список игроков</div>
        <hr>
    </div>
    <div class="lobby_team" id="lobby_team_1">
        <div id="lobby_team_head">Команда 1</div>
        <hr>
    </div>
    <div class="lobby_team" id="lobby_team_2">
        <div id="lobby_team_head">Команда 2</div>
        <hr>
    </div>
    <div class="lobby_team" id="lobby_team_3">
        <div id="lobby_team_head">Команда 3</div>
        <hr>
    </div>
    <div class="lobby_team" id="lobby_team_4">
        <div id="lobby_team_head">Команда 4</div>
        <hr>
    </div>
</div>
</template>

<script>
export default {
  name: 'AuthWin',
  data(){
    return {
        user_type: 'Master',
        failed: false
    }
  },
  methods: {
        select_tab_1: function () {
            if(this.user_type != 'Master')
                this.failed = false;
            document.getElementById('tab_1').style.textDecoration = 'underline';
            document.getElementById('tab_2').style.textDecoration = 'none';
            this.user_type = 'Master'
        },
        select_tab_2: function () {
            if(this.user_type != 'User')
                this.failed = false;
            document.getElementById('tab_2').style.textDecoration = 'underline';
            document.getElementById('tab_1').style.textDecoration = 'none';
            this.user_type = 'User'
            document.getElementById('failed_message_master').style.visibility = 'hidden';
        },
        log_in: function () {
            var email = document.getElementById('email_master').value;
            var password = document.getElementById('password').value;
            if(email == 'ведущий' && password == 'ведущий123')
                this.$emit('login-master');
            else if(email == 'админ' && password == 'админ123')
                this.$emit('login-admin');
            else
                this.failed = true;
        },
        check_failed: function () {
            if(this.failed)
                return 'visible';
            else
                return 'hidden';
        },
  },
  mounted: function () {
  this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
    document.getElementById('tab_1').style.textDecoration = 'underline';
    this.user_type = 'Master'
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#lobby_header{
    text-align: center;
    font-size: 200%;
}

#group_lobby{
    width: 100%;
    height: 100%;
}

#player_list{
    margin-top: 1%;
    margin-left: 9%;
    width: 20%;
    height: 95%;
    border: solid black 2px;
    border-radius: 20px;
    float: left;
}

#player_list_head{
    margin-top: 2%;
    text-align: center;
    font-size: 130%;
}

hr{
    width: 90%;
    color: green;
}

.lobby_team{
    margin-top: 1%;
    border-radius: 20px;
    float: left;
    border: solid black 2px;
    width: 25%;
    height: 46%;
    margin-left: 5%;
}

#lobby_team_head{
    margin-top: 2%;
    text-align: center;
    font-size: 130%;
}
</style>