<template>
    <AdminHeader @logout="log_out"/>
    <NavigationButton v-if="current_view == 'fields'" :current_text="current_text" @click="to_masters"/>
    <FieldList  v-if="current_view == 'fields'" @add-field="add_field" @select-product="select_product" :products="products" />
    <AddFields  v-if="current_view == 'fields'" @close-add-field="close_add_field" @create-field="create_field"  :is_add_product="is_add_product" />

    <ProductMenu v-if="current_view == 'questions'" :selected_product="selected_product" @to-fields="to_fields" @delete-product="delete_product" @edit-product="edit_product" />
    <QuestionsList v-if="current_view == 'questions'" @to-masters="to_masters"  @edit-question="edit_question" @final-delete-product="final_delete_product" @final-edit-product="final_edit_product" :selected_product="selected_product" :draw="draw" :products="products" ref="q_list" />
</template>

<script>
import AdminHeader from './components/AdminHeader.vue'
import NavigationButton from './components/NavigationButton.vue'
import FieldList from './components/FieldList.vue'
import AddFields from './components/AddFields.vue'
import ProductMenu from './components/ProductMenu.vue'
import QuestionsList from './components/QuestionsList.vue'

export default {
  name: 'FieldsList',
  components: {
    AdminHeader,
    NavigationButton,
    FieldList,
    AddFields,
    ProductMenu,
    QuestionsList
  }, 
  data(){
    return {
        current_text: 'Ведущие',
        is_add_product: false,
        current_view: 'fields',
        selected_product: ['СберАптека', 'background:red;color:white;'],
        draw: 'questions',
        products: [
        { text: 'Полуфинал', value: '1', color:"color:black;font-size:2.2vw;", 
          questions:[
            { id: '1', text: 'Вопрос 1', type: 'С выбором ответа', wording: 'Какой-то вопрос 1' }, 
            { id: '2', text: 'Вопрос 2', type: 'Без выбора ответа', wording: 'Какой-то вопрос 2' }, 
            { id: '3', text: 'Вопрос 3', type: 'Вопрос-аукцион', wording: 'Какой-то вопрос 3' }, 
            { id: '4', text: 'Вопрос 4', type: 'Вопрос с медиа фрагментом', wording: 'Какой-то вопрос 4' },
            ] 
        },
        { text: 'Финал', value: '2', color:"color:black;font-size:2.2vw;", 
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
      ],
    }
  },
  methods: {
        to_masters: function () {
            this.$emit('to-masters');
        },
        to_fields: function () {
            this.current_view = 'fields';
        },
        add_field: function(){
            this.is_add_product = true;
        },
            close_add_field: function(){
            this.is_add_product = false;
        },
            create_field: function(name, color){
            this.products.push({ text: name, value: this.products.lenght, color:"background:" + color, questions: [] });
        },
        select_product: function(name, color){
            if(name == 'Финал' || name == 'Полуфинал')
                this.selected_product = [name, color + ';color:black;font-size:2vw;padding-top: 15%;padding-bottom: 15%;'];
            else
                this.selected_product = [name, color + ';color:white;'];
            this.current_view = 'questions';
        },
        delete_product: function(){
            this.$refs.q_list.check_delete_product();
        },
        edit_product: function(){
            this.$refs.q_list.edit_product();
        },
        final_delete_product: function(){
            this.products = this.products.filter(option => option.text != this.selected_product[0]);
            this.current_view = 'fields';
        },
        final_edit_product: function(name, color){
            var old_name = this.selected_product[0];
            this.selected_product = [name, color];
            this.products.forEach(function(item) {
                    if(item.text == old_name)
                    {
                    item.text = name;
                    item.color = color;
                    }
                    
                });
        },
        edit_question: function(product, question_id, new_type, new_wording){
        this.products.forEach(function(item) {
                if(item.text == product)
                {
                item.questions.forEach(function(item) {
                    if(item.id == question_id)
                    {
                    console.log("In");
                    item.type = new_type;
                    item.wording = new_wording;
                    return;
                    }
                    
                });   
                }
            });
        },
        log_out: function(){
            this.$emit('logout');
        },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* .grid{
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
    line-height:100px;
    color: white;
}

.number{
    color: black;
    font-size: 500%;
    font-size: 15vw;
}

.plus{
    font-size: 600%;
    border: 2px solid silver;
    color: silver;
} */
</style>
