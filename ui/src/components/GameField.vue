<template>
    <img v-if="next=='Второй раунд'" src="@/assets/dice.png" alt="" id="dice" @click="generate_random_number">
    <div v-if="next=='Второй раунд'" id="generated_number">{{ current_number }}</div>
    <div v-if="next=='Завершить игру'" id="next_turn" @click="next_turn">Следующий ход</div>
    <div id="next_round" @click="next_round">{{ next }}</div>
    <img src="@/assets/start.png" alt="" id="start">
    <div id="timer">00:00:00</div>
    <div id="round">1 раунд</div>
    <div id="outer_field">
        <div id="inner_field"><img src="@/assets/cross.png" alt="" id="cross"></div>
    </div>
    <div class="product" v-for="(option, index) in options" :key="index" :style="option.style">{{option.text}}</div>
    <div class="chip" v-for="(player, index) in players" :key="index" :style="player.pos+player.color"></div>
    
</template>

<script>
export default {
  name: 'GameField',
  data(){
    return {
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
                { pos:'top:31%;left:40.15%;', color:'background:blue;' },
                { pos:'top:10.5%;left:68%;', color:'background:red;' },
                { pos:'top:83.5%;left:68%;', color:'background:lime;' },
                { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:31%;left:40.15%;', color:'background:blue;' },
                { pos:'top:31%;left:59.2%;', color:'background:red;' },
                { pos:'top:83.5%;left:68%;', color:'background:lime;' },
                { pos:'top:83.5%;left:31%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:31%;left:40.15%;', color:'background:blue;' },
                { pos:'top:31%;left:59.2%;', color:'background:red;' },
                { pos:'top:83.5%;left:68%;', color:'background:lime;' },
                { pos:'top:69%;left:40.15%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:31%;left:40.15%;', color:'background:blue;' },
                { pos:'top:31%;left:59.2%;', color:'background:red;' },
                { pos:'top:69%;left:59.2%;', color:'background:lime;' },
                { pos:'top:69%;left:40.15%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:48%;', color:'background:blue;' },
                { pos:'top:31%;left:59.2%;', color:'background:red;' },
                { pos:'top:69%;left:59.2%;', color:'background:lime;' },
                { pos:'top:69%;left:40.15%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:48%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:69%;left:59.2%;', color:'background:lime;' },
                { pos:'top:69%;left:40.15%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:48%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:69%;left:59.2%;', color:'background:lime;' },
                { pos:'top:52%;left:48%;', color:'background:cyan;' },
            ],
            [
                { pos:'top:42%;left:48%;', color:'background:blue;' },
                { pos:'top:42%;left:51%;', color:'background:red;' },
                { pos:'top:52%;left:51%;;', color:'background:lime;' },
                { pos:'top:52%;left:48%;', color:'background:cyan;' },
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
        ]
    }
  },
  methods: {
    generate_random_number () { 
        this.current_number = Math.floor(Math.random() * 6 + 1);
        let number = this.current_number;
        if(this.tour == 1)
        {
            this.players[this.turn].pos = this.circle[this.turn * 4];
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
        this.$emit('set-question', this.questions[this.players[this.turn].pos]);

        
        if(this.turn == 3)
        {
            this.turn = 0;
            ++this.tour;
        }
        else
            ++this.turn;
        },
    next_round () {
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
            alert('Игра окончена');
        this.next = 'Завершить игру';  
        document.getElementById('round').innerText = '2 раунд';
        },
    next_turn () {
        if(this.second_round_tour + 1 == 8)
        {
            this.next = 'Конец';
            this.players = this.second_round_states[this.second_round_tour++];
            this.$emit('set-question', [this.second_round_questions[this.second_round_tour - 1], 'Второй тур', null]);
            return;
        }
       this.players = this.second_round_states[this.second_round_tour++];
       this.$emit('set-question', [this.second_round_questions[this.second_round_tour - 1], 'Второй тур', null]);
    },  
    get_color (product) {
        for(var i = 0; i < this.options.length; ++i)
        {
            if(this.options[i].text == product)
                return this.options[i].color; 
        }
    },
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
    font-size: 220%;
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
    font-size: 220%;
}

#cross{
    height: 100%;
    width: 100%;
}

#dice{
    width: 6%;
    height: 10%;
    left: 5%;
    top: 44%;
    position: absolute;
}
#generated_number{
    width: 3%;
    height: 5%;
    left: 13%;
    top: 47%;
    position: absolute;
    text-align: center;
    font-size: 250%;
    border: solid;
    line-height: 90%;
}

#next_round{
    width: 15%;
    height: 5%;
    left: 77.5%;
    top: 47%;
    position: absolute;
    text-align: center;
    font-size: 150%;
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
}

#next_turn{
    width: 15%;
    height: 5%;
    left: 4%;
    top: 47%;
    position: absolute;
    text-align: center;
    font-size: 150%;
    line-height: 130%;
    background: rgba(33, 160, 56, 1);
    color: white;
    padding: 0.5% 2% 0.5% 2%;
    border-radius: 10px;
}
</style>
