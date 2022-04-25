<template>
     <div id="menu" class="menu">
        <div id="avatar" class="avatar" :style="selected_product[1]">
            {{selected_product[0]}}
        </div>

        <div @click="edit" id="edit">
            Редактировать
        </div>
        <div @click="delete_button" id="delete">
            Удалить
        </div>
        <div @click="back" id="back">
            К другим полям
        </div>
    </div>
</template>

<script>
export default {
  name: 'ProductMenu',
  props:['selected_product'],
  data(){
    return {
    }
  },
  methods: {
        back: function () {
            this.$emit('to-fields');
        },
        edit: function () {
            var edit = document.getElementById("edit");
            var click_delete = document.getElementById("delete");
            click_delete.style.opacity = 0.5;
            edit.style.opacity = 1;
            this.$emit('edit-product');
        },
        delete_button: function () {
            var edit = document.getElementById("edit");
            var click_delete = document.getElementById("delete");
            click_delete.style.opacity = 1;
            edit.style.opacity = 0.5;
            this.$emit('delete-product');
        }
  },
  mounted: function () {
  this.$nextTick(function () {
    // Код, который будет запущен только после
    // отображения всех представлений
    if(this.selected_product[0] == '1' || this.selected_product[0] == '2')
    {
        document.getElementById('edit').style.visibility = 'hidden';
        document.getElementById('delete').style.visibility = 'hidden';
    }
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.menu{
    float: left;
    width: 20%;
    text-align: center;
    height: 94%;
    padding-top: 1%;
    padding-bottom: 1%;
    border-right: 2px solid silver;
    margin-right: 1%;
}

.avatar{
    margin-left: 15%;
    width: 70%;
    /*color: #ffffff;*/
    padding-top: 15%;
    padding-bottom: 15%;
    border-radius: 20px;
    border: solid black 2px;
    font-size: 180%;
}

#edit, #back, #delete{
    border-radius: 20px;
    padding-top: 4%;
    padding-bottom: 4%;
    margin-left: 10%;
    width: 80%;
    color: white;
    background-color: green;
    font-size: 120%;
    font-weight: bold;
}
#edit{
    margin-top: 10%;
}
#delete{
    margin-top: 5%;
}
#back{
    margin-top: 100%;
}

#edit:hover, #back:hover, #delete:hover {
    box-shadow: 0 0 10px 100px orange inset;
}
</style>
