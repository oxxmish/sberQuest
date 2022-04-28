<script>
import AuthForm from './AuthForm.vue'
import ManageMasters from './ManageMasters.vue'
import FieldsList from './FieldsList.vue'
import MasterTemplates from './MasterTemplates.vue'
import TheGame from './TheGame.vue'
import GameLobby from './GameLobby.vue'

const routes = {
  '/': AuthForm,
  '/masters': ManageMasters,
  '/fields': FieldsList,
  '/templates': MasterTemplates,
  '/game': TheGame,
  '/lobby': GameLobby,
}

export default {
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
    start_game() {
      window.location.href = "#/game";
      this.currentPath = window.location.hash
    },
    create_game() {
      window.location.href = "#/lobby";
      this.currentPath = window.location.hash
    }
  },
  computed: {
    currentView() {
      return routes[this.currentPath.slice(1) || '/']
    }
  },
  mounted() {
    window.addEventListener('hashchange', () => {
            this.currentPath = window.location.hash
		})
  }
}
</script>

<template>
  <component :is="currentView" @login-admin="login_admin" @login-master="login_master" @to-fields="to_fields" @to-masters="to_masters" @logout="log_out" @create-game="create_game" @start-game="start_game" />
</template>

<style>
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
    height: 90%;
}
</style>