<template>
    <MasterHeader @logout="log_out" />
    <TemplateList />
</template>

<script>
import MasterHeader from './components/MasterHeader.vue'
import TemplateList from './components/TemplateList.vue'

export default {
  name: 'MasterTemplates',
  components: {
    MasterHeader,
    TemplateList,
  }, 
  data(){
    return {
    }
  },
  methods:{
    log_out: function(){
        this.$emit('logout');
    },
    start_game: function(){
        this.$emit('start-game');
    },
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>