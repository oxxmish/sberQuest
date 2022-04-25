<template>
    <div class="to_fields" @click="go_to_fields" id="to_field">{{ current_text }}</div>
</template>

<script>
export default {
  name: 'NavigationButton',
  props: ['current_text'],
  methods: {
            go_to_fields: function () {
                this.$emit('go-to-fields');
            }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.to_fields{
    height: 5%;
    background-color: green;
    border-radius: 5px;
    text-align: center;
    font-weight: bold;
    color: #ffffff;
    font-size: 175%;
}
.to_fields:hover {
    box-shadow: 0 0 10px 100px orange inset;
}
</style>
