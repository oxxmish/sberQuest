<template>
    <img v-if="next=='Второй раунд'" src="@/assets/dice.png" alt="" id="dice" @click="generate_random_number">
    <div v-if="next=='Второй раунд'" id="generated_number">{{ current_number }}</div>
    <div v-if="next=='Завершить игру'" id="next_turn" @click="next_turn">Следующий ход</div>
    <input id="price" v-show="next=='Второй раунд'" placeholder="Баллы за 2-ой раунд" @blur="save_price">
    <div id="next_round" @click="next_round">{{ next }}</div>
    <img src="@/assets/start.png" alt="" id="start" @click="go_timer">
    <div id="timer">{{timer[0]}}:{{timer[1]}}:{{timer[2]}}</div>
    <div id="round">1 раунд</div>
    <div id="outer_field">
            <div class="first_line">
              <div class="start_one" id="start_one">
                <div class="product_main_one">Старт</div>
              </div>
              <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_1" :style="calc_margin_hor()">
                <div class="product_themes_one" :id="'field_product_' + (i - 1)" :style="field_config[i - 1].colour">{{ field_config[i - 1].name }}</div>
              </div>
              <div class="start_two" id="start_two" :style="calc_margin_hor()">
                <div class="product_main_one">Старт</div>
              </div>
            </div>
            <div class="second_line">
                <div class="left_border">
                  <!-- <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_2" :style="calc_margin_ver_left(i)">
                    <div class="product_themes_one" :id="'field_product_' + (current_template.numFields - i)" :style="field_config[i - 1 + (current_template.numFields / 4)].colour">{{ field_config[i - 1 + (current_template.numFields / 4)].name }}</div>
                  </div> -->
                  <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_2" :style="calc_margin_ver_left(i)">
                    <div class="product_themes_one" :id="'field_product_' + (current_template.numFields - i)" :style="field_config[current_template.numFields - i].colour">{{ field_config[current_template.numFields - i].name }}</div>
                  </div>
                </div>
                <div class="inner_field">
                    <div class="first_line_inner">
                        <div class="half_final_one">
                          <div class="product_main_one" style="height:14%;width:14%;font-size:1vw;line-height:500%;">Полуфинал</div>
                        </div>
                        <div class="half_final_two">
                          <div class="product_main_one" style="height:14%;width:14%;font-size:1vw;line-height:500%;">Полуфинал</div>
                        </div>
                    </div>
                    <div class="second_line_inner">
                      <div class="product_final">Финал</div>
                    </div>
                    <div class="third_line_inner">
                        <div class="half_final_third">
                          <div class="product_main_one" style="height:14%;width:14%;font-size:1vw;line-height:500%;">Полуфинал</div>
                        </div>
                        <div class="half_final_four">
                          <div class="product_main_one" style="height:14%;width:14%;font-size:1vw;line-height:500%;">Полуфинал</div>
                        </div>
                    </div>
                </div>
                <div class="right_border">
                  <!-- <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_3" :style="calc_margin_ver_right(i)">
                    <div class="product_themes_one" :id="'field_product_' + (i - 1 + (current_template.numFields / 4))" :style="field_config[i - 1 + 2*(current_template.numFields / 4)].colour">{{ field_config[i - 1 + 2*(current_template.numFields / 4)].name }}</div>
                  </div> -->
                  <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_3" :style="calc_margin_ver_right(i)">
                    <div class="product_themes_one" :id="'field_product_' + (i - 1 + (current_template.numFields / 4))" :style="field_config[i - 1 + (current_template.numFields / 4)].colour">{{ field_config[i - 1 + (current_template.numFields / 4)].name }}</div>
                  </div>
                </div>
            </div>
            <div class ="third_line">
              <div class="start_third" id="start_three">
                <div class="product_main_one">Старт</div>
              </div>
              <!-- <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_4" :style="calc_margin_hor()">
                <div class="product_themes_one" :id="'field_product_' + (3*current_template.numFields/4 - i)" :style="field_config[i - 1 + 3*(current_template.numFields / 4)].colour">{{ field_config[i - 1 + 3*(current_template.numFields / 4)].name }}</div>
              </div> -->
              <div v-for="i in (current_template.numFields / 4)" :key="i" class="start_themes_4" :style="calc_margin_hor()">
                <div class="product_themes_one" :id="'field_product_' + (3*current_template.numFields/4 - i)" :style="field_config[3*current_template.numFields/4 - i].colour">{{ field_config[3*current_template.numFields/4 - i].name }}</div>
              </div>
              <div class="start_four" id="start_four" :style="calc_margin_hor()">
                <div class="product_main_one">Старт</div>
              </div>
            </div>
        </div>
    <!-- <div id="outer_field">
        <div id="inner_field"><img src="@/assets/cross.png" alt="" id="cross"></div>
    </div> -->
    <!-- <div class="product" v-for="(option, index) in options" :key="index" :style="option.style">{{option.text}}</div> -->
    <div class="chip" v-for="(player, index) in players" :key="index" :style="player.pos+player.color"></div>
    
</template>

<script>
export default {
  name: 'GameField',
  props: ['timer', 'crit_timer', 'tmpl_id', 'state'],
  data(){
    return {
        final_questions: [],
        semifinal_questions: [],
        second_tour_ids_question: [],
        second_round_price: 0,
        unique_products: [],
        current_template: {numFields: 16},
        field_config: [ {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, 
                        {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, 
                        {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, 
                        {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, {name:'1'}, ],
        // test_timer: new Date(2011, 0, 1, 4, 30, 20, 0),
        options: [
        { text: 'СберЗвук', value: '1', style:"top:11.5%;left:38.1%;font-size: 105%;background-color:#B22222;color:white;", color:'background-color:#B22222;color:white;' },
        { text: 'РаботаРу', value: '2', style:"top:11.5%;left:44.5%;font-size: 105%;background-color:blue;color:white;", color:'background-color:blue;color:white;' },
        { text: 'Окко', value: '3', style:"top:11.5%;left:50.9%;font-size: 110%;background-color:DeepPink;color:white;", color:'background-color:DeepPink;color:white;' },
        { text: 'СберДиск', value: '4', style:"top:11.5%;left:57.2%;font-size: 105%;background-color:DarkCyan;color:white;", color:'background-color:DarkCyan;color:white;' },
        { text: 'СберБокс', value: '5', style:"top:75%;left:38.1%;font-size: 105%;background-color:purple;color:white;", color:'background-color:purple;color:white;' },
        { text: 'СберМаркет', value: '6', style:"top:75%;left:44.5%;font-size: 80%;line-height: 500%;background-color:Navy;color:white;", color:'background-color:Navy;color:white;' },
        { text: 'ДеливериКлаб', value: '7', style:"top:75%;left:50.9%;font-size: 73%;line-height: 570%;background-color:MediumSlateBlue;color:white;", color:'background-color:MediumSlateBlue;color:white;' },
        { text: 'Самокат', value: '8', style:"top:75%;left:57.2%;font-size: 105%;background-color:RosyBrown;color:white;", color:'background-color:RosyBrown;color:white;' },
        { text: 'СитиМобил', value: '9', style:"top:24.3%;left:31.7%;font-size: 90%;line-height: 500%;background-color:DimGray;color:white;", color:'background-color:DimGray;color:white;' },
        { text: 'СберПрайм', value: '10', style:"top:37%;left:31.7%;font-size: 90%;line-height: 500%;background-color:DarkOrange;color:white;", color:'background-color:DarkOrange;color:white;' },
        { text: 'СберПрайм+', value: '11', style:"top:49.5%;left:31.7%;font-size: 85%;line-height: 550%;background-color:DarkSlateGrey;color:white;", color:'background-color:DarkSlateGrey;color:white;' },
        { text: 'СберМобайл', value: '12', style:"top:62.4%;left:31.7%;font-size: 80%;line-height: 550%;background-color:SaddleBrown;color:white;", color:'background-color:SaddleBrown;color:white;' },
        { text: 'СберЕАптека', value: '13', style:"top:24.3%;left:63.5%;font-size: 75%;line-height: 575%;background-color:Crimson;color:white;", color:'background-color:Crimson;color:white;' },
        { text: 'ДомКлик', value: '14', style:"top:37%;left:63.5%;font-size: 105%;background-color:Indigo;color:white;", color:'background-color:Indigo;color:white;' },
        { text: 'СберЗдоровье', value: '15', style:"top:49.5%;left:63.5%;font-size: 75%;line-height: 600%;background-color:Olive;color:white;", color:'background-color:Olive;color:white;' },
        { text: 'СберМегаМаркет', value: '16', style:"top:62.4%;left:63.5%;font-size: 60%;line-height: 730%;background-color:Black;color:white;", color:'background-color:Black;color:white;' },
        { text: 'Старт', value: '17', style:"top:11.5%;left:31.7%;font-size: 125%;line-height: 350%;font-weight: bold;" },
        { text: 'Старт', value: '18', style:"top:75%;left:31.7%;font-size: 125%;line-height: 350%;font-weight: bold;" },
        { text: 'Старт', value: '19', style:"top:11.5%;left:63.5%;font-size: 125%;line-height: 350%;font-weight: bold;" },
        { text: 'Старт', value: '20', style:"top:75%;left:63.5%;font-size: 125%;line-height: 350%;font-weight: bold;" },
        { text: 'Полуфинал', value: '21', style:"top:24.3%;left:38.1%;font-size: 85%;line-height: 500%;;font-weight: bold;" },
        { text: 'Полуфинал', value: '22', style:"top:62.4%;left:38.1%;font-size: 85%;line-height: 500%;;font-weight: bold;" },
        { text: 'Полуфинал', value: '23', style:"top:24.3%;left:57.2%;font-size: 85%;line-height: 500%;;font-weight: bold;" },
        { text: 'Полуфинал', value: '24', style:"top:62.4%;left:57.2%;font-size: 85%;line-height: 500%;;font-weight: bold;" },
        { text: 'Финал', value: '25', style:"top: 38%;left: 45%;font-size: 175%;line-height: 520%;font-weight: bold;height: 20%;width: 10%;" },
        ],
        current_number: 0,
        next: 'Второй раунд',
        turn: 0,
        tour: 1,
        second_round_tour: 0,
        second_round_states: [
            [
                { pos:'top:26.5%;left:39.5%;', color:'background:blue;' },
                { pos:'top:10.5%;left:68%;', color:'background:red;' },
                { pos:'top:83.5%;left:68%;', color:'background:lime;' },
                { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:26.5%;left:39.5%;', color:'background:blue;' },
                { pos:'top:26.5%;left:59.2%;', color:'background:red;' },
                { pos:'top:83.5%;left:68%;', color:'background:lime;' },
                { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:26.5%;left:39.5%;', color:'background:blue;' },
                { pos:'top:26.5%;left:59.2%;', color:'background:red;' },
                { pos:'top:67%;left:59%;', color:'background:lime;' },
                { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:26.5%;left:39.5%;', color:'background:blue;' },
                { pos:'top:26.5%;left:59.2%;', color:'background:red;' },
                { pos:'top:67%;left:59%;', color:'background:lime;' },
                { pos:'top:67%;left:39.5%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:47%;', color:'background:blue;' },
                { pos:'top:26.5%;left:59.2%;', color:'background:red;' },
                { pos:'top:67%;left:59%;', color:'background:lime;' },
                { pos:'top:67%;left:39.5%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:47%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:67%;left:59%;', color:'background:lime;' },
                { pos:'top:67%;left:39.5%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:47%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:52%;left:51%;', color:'background:lime;' },
                { pos:'top:67%;left:39.5%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:47%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:52%;left:51%;', color:'background:lime;' },
                { pos:'top:52%;left:47%;', color:'background:cyan;' },
            ],
        ],
        players: [
            { pos:'top:10.5%;left:31%;', color:'background:blue;' },
            { pos:'top:10.5%;left:68%;', color:'background:red;' },
            { pos:'top:83.5%;left:68%;', color:'background:lime;' },
            { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
        ],
        circle: [
            //'top:10.5%;left:31%;',  // start[0]
            'top:8.5%;left:40.1%;',
            'top:8.5%;left:46.5%;',
            'top:8.5%;left:52.8%;',
            'top:8.5%;left:59.2%;',
            //'top:10.5%;left:68%;',  // start[5]
            'top:28.3%;left:68.9%;',
            'top:41%;left:68.9%;',
            'top:53.5%;left:68.9%;',
            'top:66.5%;left:68.9%;',
            //'top:83.5%;left:68%;',  // start[10]
            'top:85.6%;left:59.3%;',
            'top:85.6%;left:52.9%;',
            'top:85.6%;left:46.5%;',
            'top:85.6%;left:40%;',
            //'top:83.5%;left:31%;', // start[15]
            'top:66.5%;left:30.3%;',
            'top:53.7%;left:30.3%;',
            'top:41.3%;left:30.3%;',
            'top:28.5%;left:30.3%;',
        ],

        // top: 10.5%;left: 31%; top: 83.5%;left: 31%; top: 83.5%;left: 68%; top: 10.5%;left: 68%;
        // top: 28.5%;left: 30.3%; top: 41.3%; top: 53.7%; top: 66.5%;
        // top: 85.6%; left: 40%; left: 46.5%; left: 52.9%; left: 59.3%;
        // top:66.5%;left:68.9%; top:53.5%; top:41%; top:28.3%;
        // top: 8.5%;left:59.2%; left:52.8%; left:46.5%; left: 40.1%;

        // 0 1 2 3 4 5
        //         *
        // step = 3
        // i = 4
        // length = 6
        // arr[-(length - (step + i))]
        questions: {
            // 'СберЗвук': ['Вопрос1']
            'top:8.5%;left:40.1%;': ['Почему мне надо пользоваться приложением СберЗвук? Назовите минимум 3 преимущества', 'Без выбора ответа', 'СберЗвук'],
            'top:8.5%;left:46.5%;': ['В каком году Работа.ру вошла в Экосистему Сбера?\nВарианты ответа: 2019, 2020, 2017', 'С выбором ответа', 'РаботаРу'],
            'top:8.5%;left:52.8%': ['Какое кол-во контента в Окко в подписке Лайт?', 'Вопрос-аукцион', 'Окко'],
            'top:8.5%;left:59.2%;': ['Сколько ГБ в облачном хранении СберДиск Вы можете получить бесплатно?', 'Вопрос-аукцион', 'СберДиск'],
            'top:28.3%;left:68.9%;': ['Что такое СберЕАптека?', 'Без выбора ответа', 'СберЕАптека'],
            'top:41%;left:68.9%;': ['Какой период дается клиенту на поиск обьекта недвижимости после одобрения заявки на ипотеку?\nВарианты ответа: 90 дней, 30 календарных дней, 100 дней', 'С выбором ответа', 'ДомКлик'],
            'top:53.5%;left:68.9%;': ['Каким образом можно связываться с врачом?', 'Без выбора ответа', 'СберЗдоровье'],
            'top:66.5%;left:68.9%;': ['На базе какого маркетплейса создан СберМегаМаркет?', 'Без выбора ответа', 'СберМегаМаркет'],

            'top:85.6%;left:59.3%;': ['Доставляет ли Самокат еду в горячем виде?\nВарианты ответа: Да, нет', 'С выбором ответа', 'Самокат'],
            'top:85.6%;left:52.9%;': ['Сколько ресторанов-партнёров в сервисе DeliveryClub?', 'Вопрос-аукцион', 'ДеливериКлаб'],
            'top:85.6%;left:46.5%;': ['В какие сроки возможен возврат доставленных продуктов?', 'Без выбора ответа', 'СберМаркет'],
            'top:85.6%;left:40%;': ['Что представляет собой SberBox?', 'Без выбора ответа', 'СберБокс'],
            'top:66.5%;left:30.3%;': ['Как оплатить услуги связи назовите, минимум 5 способов?', 'Без выбора ответа', 'СберМобайл'],
            'top:53.7%;left:30.3%;': ['Какое количество сервисов доступно по подписке?', 'Без выбора ответа', 'СберПрайм+'],
            'top:41.3%;left:30.3%;': ['Сколько стоит подписка?', 'Без выбора ответа', 'СберПрайм'],
            'top:28.5%;left:30.3%;': ['Каким образом заказать такси, если закончился трафик?', 'Без выбора ответа', 'СитиМобил'],
        },
        second_round_questions: [
            'отработать сомнение клиента, которому предлагается СберМобайл: "У меня безлимитный интернет"?',
            'отработать сомнение клиента, которому предлагается СберМобайл: "У меня безлимитный интернет"?',
            'отработать сомнение клиента, которому предлагается СберМобайл: "У меня безлимитный интернет"?',
            'отработать сомнение клиента, которому предлагается СберМобайл: "У меня безлимитный интернет"?',
            'Команда рассказывает позитивный опыт или лайфхак по продукту',
            'Необходимо назвать минимум одну жизненную ситуацию, в которой выпавший продукт будет особенно ценен и выгоден клиенту',
            'Команда рассказывает позитивный опыт или лайфхак по продукту',
            'Необходимо назвать минимум одну жизненную ситуацию, в которой выпавший продукт будет особенно ценен и выгоден клиенту',
        ],
        current_question_id: null,
    }
  },
  methods: {
    generate_random_number () { 
        if(this.current_number == 0)
        {
            this.init_circle_chip_positions();
            this.init_questions();
        }
            
        this.current_number = Math.floor(Math.random() * 6 + 1);
        let number = this.current_number;
        if(this.tour == 1)
        {
            this.players[this.turn].pos = this.circle[this.turn * (this.current_template.numFields / 4)];
            --number;
        }
           
        for(var i = 0; i < this.circle.length; ++i)
        {
            if(this.circle[i] == this.players[this.turn].pos && i + number < this.circle.length)
            {
                this.players[this.turn].pos = this.circle[i + number];
                break;
            }
            else if(this.circle[i] == this.players[this.turn].pos && i + number >= this.circle.length)
            {
                this.players[this.turn].pos = this.circle[-(this.circle.length - (number + i))];
                break;
            }
        }
        
        this.$emit('set-question', this.questions[this.players[this.turn].pos], this.turn);
        console.log(this.questions[this.players[this.turn].pos][3]);
        fetch("http://api.vm-96694bec.na4u.ru/game/chooseQuestion", {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({questionId:this.questions[this.players[this.turn].pos][3], questionType:"REGULAR", state:"smth"})}) 
        this.update_questions(this.players[this.turn].pos);

        if(this.turn == 3)
        {
            this.turn = 0;
            ++this.tour;
        }
        else
            ++this.turn;
        },
    next_round () {
        if(document.getElementById('round').innerText != '2 раунд' && this.second_round_price == 0)
        {
          alert("Количество баллов на второй тур не установлено");
          return;
        }
        this.second_round_questions.length = 0;
        this.second_tour_ids_question.length = 0;
        for( let i = 0; i < this.semifinal_questions.length; ++i )
        {
          this.second_round_questions.push(this.semifinal_questions[i].text);
          this.second_tour_ids_question.push(this.semifinal_questions[i].id);
        }
          
        for( let i = 0; i < this.final_questions.length; ++i )
        {
          this.second_round_questions.push(this.final_questions[i].text);
          this.second_tour_ids_question.push(this.final_questions[i].id);
        }
          

        console.log(this.second_round_questions);
        if(document.getElementById('round').innerText != '2 раунд')
        {
            this.players = [
            { pos:'top:10.5%;left:31%;', color:'background:blue;' },
            { pos:'top:10.5%;left:68%;', color:'background:red;' },
            { pos:'top:83.5%;left:68%;', color:'background:lime;' },
            { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ];
            this.$emit('next-round');
        }
        else
        {
          this.$emit('end-game');
          return;
        }
            
        this.next = 'Завершить игру';  
        document.getElementById('round').innerText = '2 раунд';
        },
    next_turn () {
        if(this.second_round_tour + 1 == 8)
        {
            this.next = 'Конец';
            this.players = this.second_round_states[this.second_round_tour++];
            this.$emit('set-question', [this.second_round_questions[this.second_round_tour - 1], 'Второй тур', this.second_round_tour < 4 ? 'Полуфинал' : 'Финал'], this.second_round_tour - 1);
            return;
        }
       this.players = this.second_round_states[this.second_round_tour++];
       this.$emit('set-question', [this.second_round_questions[this.second_round_tour - 1], 'Второй тур', this.second_round_tour < 4 ? 'Полуфинал' : 'Финал'], this.second_round_tour - 1);
       fetch("http://api.vm-96694bec.na4u.ru/game/chooseQuestion", {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({questionId:this.second_tour_ids_question[this.second_round_tour - 1], questionType:"REGULAR", state:"smth"})}) 
    },  
    get_color (product) {
        for(var i = 0; i < this.field_config.length; ++i)
        {
            if(this.field_config[i].name == product)
                return this.field_config[i].colour; 
        }
    },
    go_timer () {
        var tmp = new Date(2011, 0, 1, this.timer[0], this.timer[1], this.timer[2], 0);
        var timer = setInterval(tick,1000);
        var crit_time = this.crit_timer;
        function tick(){
            tmp = new Date(tmp - 1000);

            document.getElementById('timer').innerText = (tmp.getHours() < 10 ? '0' + String(tmp.getHours()) : String(tmp.getHours())) + ':' + (tmp.getMinutes() < 10 ? '0' + String(tmp.getMinutes()) : String(tmp.getMinutes())) + ':' + (tmp.getSeconds() < 10 ? '0' + String(tmp.getSeconds()) : String(tmp.getSeconds()));
            if(tmp.getHours() == Number(crit_time[0]) && tmp.getMinutes() == Number(crit_time[1]) && tmp.getSeconds() == Number(crit_time[2]))
                document.getElementById('timer').style.color = 'red';
                
            if(tmp.getHours() == 0 && tmp.getMinutes() == 0 && tmp.getSeconds() == 0)
                clearInterval(timer);
        }
    },
    save_template_product: function (data) {
      this.current_template = data;
      let ar_ref = this.field_config;
      ar_ref.length = 0;
      this.current_template.products.forEach(element => {
          if(element.name == "Финал")
            element.questions.forEach(question => {this.final_questions.push(question);} )
          if(element.name == "Полуфинал")
            element.questions.forEach(question => {this.semifinal_questions.push(question);} )
          if(element.numOfRepeating > 0)
            this.unique_products.push(element);
          for( let i = 0; i < element.numOfRepeating; ++i )
            ar_ref.push(element);
      });
      this.custom_shuffle(this.field_config);
      this.field_config.forEach(element => {
          this.custom_shuffle(element.questions);
      });
      this.set_field_config();
    },
    custom_shuffle: function (array) {
      for (let i = array.length - 1; i > 0; i--) {
            let j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    },
    calc_margin_hor: function () {
        console.log(this.current_template.numFields);
        if(this.current_template.numFields == 16)
            return "margin-left:5.6%";
        else if(this.current_template.numFields == 20)
            return "margin-left:3%";
        else if(this.current_template.numFields == 24)
            return "margin-left:1.2%";
    },
    calc_margin_ver_left: function (i) {
        if(this.current_template.numFields == 16)
            return "margin-top:75%";
        else if(this.current_template.numFields == 20)
            return "margin-top:45%";
        else if(this.current_template.numFields == 24 && i == 1)
            return "margin-top:17%";
        else if(this.current_template.numFields == 24)
            return "margin-top:28%";
    },
    calc_margin_ver_right: function (i) {
        if(this.current_template.numFields == 16 && i == 1)
            return "margin-top:65%";
        if(this.current_template.numFields == 16)
            return "margin-top:70%";
        else if(this.current_template.numFields == 20 && i == 1)
            return "margin-top:42%";
        else if(this.current_template.numFields == 20)
            return "margin-top:40%";
        else if(this.current_template.numFields == 24 && i == 1)
            return "margin-top:15%";
        else if(this.current_template.numFields == 24)
            return "margin-top:25%";
    },
    init_chip_positions: function () {
        let body = document.body;
        let body_bottom = body.getBoundingClientRect().bottom;
        let body_right = body.getBoundingClientRect().right;

        let start_one = document.getElementById("start_one");
        let top = start_one.getBoundingClientRect().top;
        let left = start_one.getBoundingClientRect().left;
        this.players[0].pos = 'left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100) + '%;';
      

        let start_two = document.getElementById("start_two");
        top = start_two.getBoundingClientRect().top;
        left = start_two.getBoundingClientRect().left;
        this.players[1].pos = 'left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100) + '%;';

        let start_three = document.getElementById("start_three");
        top = start_three.getBoundingClientRect().top;
        left = start_three.getBoundingClientRect().left;
        this.players[3].pos = 'left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100 - 3) + '%;';

        let start_four = document.getElementById("start_four");
        top = start_four.getBoundingClientRect().top;
        left = start_four.getBoundingClientRect().left;
        this.players[2].pos = 'left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100 - 3) + '%;';

    },
    init_circle_chip_positions: function () {
        let body = document.body;
        let body_bottom = body.getBoundingClientRect().bottom;
        let body_right = body.getBoundingClientRect().right;
        let ar = this.circle;
        ar.length = 0;
        for( let i = 0; i < this.field_config.length; ++i )
        {
          let field = document.getElementById("field_product_" + String(i));
          let top = field.getBoundingClientRect().top;
          let left = field.getBoundingClientRect().left;
          if( i < this.current_template.numFields / 4)
            ar.push('left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100) + '%;');
          else if( i < this.current_template.numFields / 2)
            ar.push('left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100 - 0.5*(i - this.current_template.numFields / 4)) + '%;');
          else if( i < 3 * this.current_template.numFields / 4)
            ar.push('left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100 - 3) + '%;');
          else if( i < this.current_template.numFields)
            ar.push('left:' + String(left/body_right * 100) + '%;top:' + String(top/body_bottom * 100 - 3 + 0.5*(i - 3*this.current_template.numFields / 4)) + '%;');
        }
        console.log(this.circle);
    },
    init_questions: function () {
      let mapping = new Map();
      mapping.set("TEXT", "Без выбора ответа").set("AUCTION", "Вопрос-аукцион").set("TEXT_WITH_ANSWERS", "С выбором ответа").set("MEDIA", "Вопрос с медиа фрагментом");
      this.questions = {};
      for( let i = 0; i < this.field_config.length; ++i)
      {
        this.questions[this.circle[i]] = [this.field_config[i].questions[0].text, mapping.get(this.field_config[i].questions[0].questionType), this.field_config[i].name, this.field_config[i].questions[0].id];
      }
      console.log(this.questions);
    },
    update_questions: function (current_pos) {
      console.log("try update question");
      let mapping = new Map();
      mapping.set("TEXT", "Без выбора ответа").set("AUCTION", "Вопрос-аукцион").set("TEXT_WITH_ANSWERS", "С выбором ответа").set("MEDIA", "Вопрос с медиа фрагментом");
      
      let current_index = 0;
      for(let i = 0; i < this.circle.length; ++i)
      {
        if(this.circle[i] == current_pos)
        {
          current_index = i;
          break;
        }
      }
      console.log(this.field_config);
      if(this.field_config[current_index].questions.length > 1)
      {
        console.log("update");
        console.log(this.field_config[current_index].questions.length);
        this.field_config[current_index].questions.shift();
        console.log(this.field_config[current_index].questions.length);
        this.init_questions();
      }
      console.log(this.field_config);
    },
    set_field_config: function () {
      console.log("set_congfig");
      this.$emit('set-config', this.field_config);
      this.$emit('set-unique', this.unique_products);
    },
    set_db_config: function (config) {
      console.log(config);
      this.current_template.numFields = config.length;
      this.field_config = config;
    },
    save_price: function () {
      this.second_round_price = document.getElementById("price").value;
    },
    get_price: function () {
      return this.second_round_price;
    },
    sleep: function (milliseconds) {
            var start = new Date().getTime();
            for (var i = 0; i < 1e7; i++) {
                if ((new Date().getTime() - start) > milliseconds){
                break;
                }
            }
        },
  },
  mounted: function () {
      let id = this.tmpl_id;
  this.$nextTick(function () {
    if(id)
      fetch("http://api.vm-96694bec.na4u.ru/board/get/" + String(id), {
                method: "GET",
                headers: {'Content-Type': 'application/json'}
                }).then( res => res.json() ).then( data => this.save_template_product(data) );
                this.init_chip_positions();
              // this.init_circle_chip_positions();
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#outer_field{
    height: 81%;
    width: 40.1%;
    /* background-color:green; */
    background-color: rgba(33, 160, 56, 1);
    border-radius: 25px;
    border: solid black 2px;
    position: absolute;
    left: 30%;
    top: 7.5%;
}
#inner_field{
    height: 80%;
    width: 80%;
    margin-top: 10%;
    margin-left: 10%;
    background-color:white;
    border: solid black 2px;
    border-radius: 25px;
}
.product{
    border-radius: 50%;
    height: 10%;
    width: 5%;
    background-color: white;
    border: solid black 2px;
    position: absolute;
    text-align: center;
    line-height: 400%;
}
#timer{
    left: 37%;
    position: absolute;
    font-size: 2.2vw;
}

#start{
    width: 3%;
    height: 5%;
    left: 33%;
    position: absolute;
    margin-top: 0.1%;
}

#round{
    left: 60%;
    position: absolute;
    font-size: 2.2vw;
}

#cross{
    height: 100%;
    width: 100%;
    transform: none;
}

#dice{
    width: 6%;
    height: 10%;
    left: 5%;
    top: 44%;
    position: absolute;
}

img{
  transition: transform .25s ease;
}

img:hover {
  transform: scale(1.2); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}

#generated_number{
    width: 3%;
    height: 5%;
    left: 13%;
    top: 47%;
    position: absolute;
    text-align: center;
    font-size: 2.8vw;
    border: solid;
    line-height: 90%;
}

#price{
  position: absolute;
  text-align: center;
  width: 10%;
    height: 5%;
    left: 81.5%;
    top: 43%;
    font-size: 1vw;
}

#next_round{
    width: 15%;
    height: 5%;
    left: 77.5%;
    top: 50%;
    position: absolute;
    text-align: center;
    font-size: 1.6vw;
    line-height: 130%;
    background: rgba(33, 160, 56, 1);
    color: white;
    padding: 0.5% 2% 0.5% 2%;
    border-radius: 10px;
}

.chip{
    border-radius: 50%;
    height: 2%;
    width: 1%;
    border: solid black 2px;
    position: absolute;
    z-index: 3;
}

#next_turn{
    width: 15%;
    height: 5%;
    left: 4%;
    top: 47%;
    position: absolute;
    text-align: center;
    font-size: 1.5vw;
    line-height: 130%;
    background: rgba(33, 160, 56, 1);
    color: white;
    padding: 0.5% 2% 0.5% 2%;
    border-radius: 10px;
}

#next_round:hover {
    box-shadow: 0 0 10px 100px orange inset;
}

#next_turn:hover {
    box-shadow: 0 0 10px 100px orange inset;
}





.half_final_one{
    margin-top: 14%;
    margin-left: 14%;
  float: left;
}
.half_final_two{
    margin-top: 14%;
    margin-left: 54%;
  float: left;
}
.half_final_third{
    margin-top: -12%;
    margin-left: 14%;
  float: left;
}
.half_final_four{
  margin-top: -12%;
  margin-left: 67%;
  float: left;
}
.first_line_inner{
  width: 100%;
  height: 20%;
}
.second_line_inner{
  width: 100%;
  height: 59%;
}
.third_line_inner{
  width: 100%;
  height: 20%;
}
.right_border{
float: left;
  height: 90%;
  width: 10%;
}
.left_border{
float: left;
height: 90%;
width: 9%;
}
.inner_field{
    margin-left: 0.5%;
    height: 100%;
    width: 79%;
    border: solid black 2px;
    border-radius: 25px;
    float: left;
    margin-top: -5%;
    background:
         linear-gradient(to top left,
             rgba(0,0,0,0) 0%,
             rgba(0,0,0,0) calc(50% - 6px),
             rgba(0,0,0,1) 50%,
             rgba(0,0,0,0) calc(50% + 6px),
             rgba(0,0,0,0) 100%),
         linear-gradient(to top right,
             rgba(0,0,0,0) 0%,
             rgba(0,0,0,0) calc(50% - 6px),
             rgba(0,0,0,1) 50%,
             rgba(0,0,0,0) calc(50% + 6px),
             rgba(0,0,0,0) 100%),
          white;
}
.start_one{
    margin-top: 5%;
    margin-left: 4.5%;
    height: 100%;
    width: 10%;
    float: left;
}
.start_two{
    margin-top: 5%;
    margin-left: 5.6%;
    height: 100%;
    width: 10%;
  float: left;
}
.start_third{
    margin-top: -7%;
    margin-left: 4.5%;
    height: 100%;
    width: 10%;
  float: left;
}
.start_four{
    margin-top: -7%;
    margin-left: 5%;
    height: 100%;
    width: 10%;
  float: left;
}
.start_themes_1{
    margin-left: 5.6%;
    height: 100%;
    width: 10%;
    float: left;
    z-index:2;
    margin-top: 5%;
}
.start_themes_2{
    margin-top: 75%;
    height: 12%;
    width: 100%;
    float: left;
    z-index:2;
    margin-left: 50%;
}
.start_themes_3{
    margin-top: 65%;
    height: 12%;
    width: 120%;
    float: left;
    z-index:2;
    margin-left: -60%;
}
.start_themes_4{
    margin-left: 5.5%;
    height: 100%;
    width: 10%;
    float: left;
    z-index:2;
    margin-top: -7%;
}
.product_main_one{
    border-radius: 50%;
    height: 11%;
    width: 11%;
    background-color: white;
    border: solid black 2px;
    position: absolute;
    text-align: center;
    line-height: 360%;
    float: left;
    z-index:2;
    font-size: 1.1vw;
}
.product_final{
    border-radius: 50%;
    height: 51%;
    width: 30%;
    margin-left: 34%;
    margin-top: 14%;
    background-color: white;
    border: solid black 2px;
    text-align: center;
    font-size: 2.5vw;
    line-height: 400%;
    float: left;
    z-index:2;
}
.product_themes_one{
    border-radius: 50%;
    height: 11%;
    width: 11%;
    /* height: 5%;
    width: 5%; */
    background-color: red;
    border: solid black 2px;
    position: absolute;
    text-align: center;
    line-height: 400%;
    float: left;
    z-index:2;
    font-size: 0.9vw;
}
.first_line{
  width: 100%;
  height: 10%;
}
.third_line{
  width: 100%;
  height: 10%;
}
.second_line{
  width: 100%;
  height: 80%;
}
</style>
