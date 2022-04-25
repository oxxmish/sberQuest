<template>
    <div class="grid" id="grid">
        <div class="grid_element" v-for="(option, index) in options" :key="index">{{ option.text }}</div>
        <div class="grid_element plus" @click="add_product">+</div>
    </div>
</template>

<script>
export default {
  name: 'TemplateList',
  data(){
    return {
        options: [
            { text: 'Шаблон комнаты 1', value: '1' },
            { text: 'Шаблон комнаты 2', value: '2' },
        ]
    }
  },
  methods: {
        add_product: function () {
                    this.options.push({ text: "Новый шаблон " + (this.options.length + 1), value: this.options.lenght });
                }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.grid{
    margin-top: 3%;
    margin-left: 5%;
    width: 90%;
    height: 80%;
}

.grid_element{
    margin-left: 2%;
    margin-right: 2%;
    margin-bottom: 5%;
    float: left;
    width: 20%;
    height: 20%;
    border: 2px solid black;
    border-radius: 20px;
    text-align: center;
    font-size: 170%;
    line-height:100px;
    color: black;
}

.plus{
    font-size: 600%;
    border: 2px solid silver;
    color: silver;
}
</style>