<template>
     <div class="grid" id="grid">
        <div class="grid_element" v-for="(option, index) in products" @click="select_product" :key="index" v-bind:style="option.color">{{ option.text }}</div>
        <div class="grid_element plus" @click="add_product">+</div>
    </div>
</template>

<script>
export default {
  name: 'FieldList',
  props:['products'],
  data(){
    return {
    }
  },
  methods: {
        go_to_fields: function () {
            this.$emit('go-to-fields');
        },
        add_product: function () {
            this.$emit('add-field');
        },
        select_product: function (event) {
            this.$emit('select-product', event.target.innerHTML, 'background:' + event.target.style.backgroundColor);
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
    width: 15%;
    height: 20%;
    border: 2px solid black;
    border-radius: 20px;
    text-align: center;
    /* font-size: 220%; */
    font-size: 2vw;
    /* line-height:100px; */
    line-height: 7vw;
    color: white;
}

.number{
    color: black;
    /* font-size: 500%; */
    font-size: 2vw;
}

.plus{
    /* font-size: 600%; */
    font-size: 6vw;
    border: 2px solid silver;
    color: silver;
}
</style>
