<script>
import AuthForm from './AuthForm.vue'
import ManageMasters from './ManageMasters.vue'
import FieldsList from './FieldsList.vue'
import MasterTemplates from './MasterTemplates.vue'
import TheGame from './TheGame.vue'
import GameLobby from './GameLobby.vue'
import MasterPanel from './MasterPanel.vue'
import RegistrationForm from './RegistrationForm.vue'

const routes = {
  '/': AuthForm,
  '/masters': ManageMasters,
  '/fields': FieldsList,
  '/templates': MasterTemplates,
  '/game': TheGame,
  '/lobby': GameLobby,
  '/status': MasterPanel,
  '/reg': RegistrationForm
}

export default {
  name: 'MainApp',
  data() {
    return {
      currentPath: window.location.hash
    }
  },
  methods: {
    login_admin() {
      window.location.href = "#/fields";
      this.currentPath = window.location.hash
    },
    login_master() {
      window.location.href = "#/templates";
      this.currentPath = window.location.hash
    },
    to_fields() {
      window.location.href = "#/fields";
      this.currentPath = window.location.hash
    },
    to_masters() {
      window.location.href = "#/masters";
      this.currentPath = window.location.hash
    },
    log_out() {
      window.location.href = "#/";
      this.currentPath = window.location.hash
    },
    start_game(teams, timer, crit_timer) {
      window.location.href = "#/game";
      this.currentPath = window.location.hash;
      //console.log(this.$refs.component);
      // this.$refs.component.set_players(teams);
      this.teams = teams;
      this.timer = timer;
      this.crit_timer = crit_timer;
    },
    create_game(tmpl_id) {
      window.location.href = "#/lobby";
      this.currentPath = window.location.hash;
      this.tmpl_id = tmpl_id;
    },
    already_registered() {
      window.location.href = "#/";
      this.currentPath = window.location.hash
    },
    go_to_reg() {
      window.location.href = "#/reg";
      this.currentPath = window.location.hash
    },
  },
  computed: {
    currentView() {
      return routes[this.currentPath.slice(1) || '/']
    }
  },
  mounted() {
    window.addEventListener('hashchange', () => {
            this.currentPath = window.location.hash
            
      // if(this.currentPath.slice(1) == "/game" && this.$refs)
      //   this.$refs.component.set_players(this.teams);
		});
  }
}
</script>

<template>
  <component ref="component" :is="currentView" :teams="teams" :timer="timer" :crit_timer="crit_timer" :tmpl_id="tmpl_id" @login-admin="login_admin" @login-master="login_master" @to-fields="to_fields" @to-masters="to_masters" @logout="log_out" @create-game="create_game" @start-game="start_game" @already-registered="already_registered" @go-to-reg="go_to_reg" />
</template>

<style>
@import url('http://fonts.cdnfonts.com/css/menlo');
#app{
  height: 100%;
}
html {
    height: 100%;
    width: 100%;
    overflow: auto;
    -ms-overflow-style: none;
    scrollbar-width: none;
    font-family: 'Roboto Light', sans-serif;
}

body {
    width: 99%;
    height: 95%;
}
</style>