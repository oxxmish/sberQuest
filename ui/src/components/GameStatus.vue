<template>
    <div class="telo">
      <div class="block_quest">
        <div class="block_background">
            <div class="name_quest" >
              Текущий вопрос
            </div>
            <div class="telo_quest"  >
              {{question[0]}}
            </div>
        </div>
      </div>
      <div class="block_param">
        <div class="block_background_2">
          <div class="name_answer" >
              Ответ
            </div>
            <div class="telo_answer">
              {{question[1]}}
            </div>
        </div>
        <div class="block_background_3">
        </div>
        <div class="block_background_3">
        </div>
      </div>
  </div>
</template>

<script>

export default {
  name: 'GameStatus',
  data () {
    return {
      question: ['Yrygvay', 'SHARK number ONE'],
      polling: null
    }
  },
  methods: {
            pollData () {
        //         this.polling = setInterval(() => {
        //            fetch("endpoint", {
        //             method: "GET",
        //             headers: {'Content-Type': 'application/json'}, 
        //             /*body: JSON.stringify(this.questions[this.players[this.turn].pos])*/
        //             }).then(res => {
        //             console.log("Request complete! response:", res);
        // });
        //         }, 1000)
	}
  },
    beforeUnmount () {
        clearInterval(this.polling)
    },
    created () {
        this.pollData()
    }
}
</script>

<style>
html {
    height: 100%;
    width: 100%;
}

body {
    width: 99%;
    height: 95%;
}
#app{
  height: 100%;
    width: 100%;
}
.telo {
    width: 99%;
    height: 94%;
    background: rgb(33, 160, 56);
}
.block_quest {
    width: 50%;
    height: 100%;
    float: left ;
}
.block_param {
    width: 49%;
    height: 100%;
    float: left ;
}
.block_background{
    width: 95%;
    height: 95%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    border-radius: 5%;
    margin-top: 2%;
    margin-left: 2%;
}
.block_background_2{
    width: 95%;
    height: 25%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    margin-top: 2%;
    margin-left: 2%;
    border-radius: 25px;
}
.block_background_3{
    width: 95%;
    height: 33%;
    float: left ;
    background: rgba(255, 255, 255, 0.7);
    margin-top: 2%;
    margin-left: 2%;
    border-radius: 25px;
}
.name_quest {
    width: 95%;
    height: 5%;
    float: left ;
    border-bottom: 2px solid green;
    text-align: center;
    margin-left: 2%;
    font-size: 1.5vw;
    margin-top: 2%;
}
.telo_quest {
    width: 99%;
    height: 80%;
    float: left ;
    text-align: center;
    font-size: 1.5vw;
    vertical-align:auto;
}
.name_answer {
    width: 95%;
    height: 18%;
    float: left ;
    border-bottom: 2px solid green;
    text-align: center;
    margin-left: 2%;
    font-size: 1.5vw;
    margin-top: 2%;
}
.telo_answer {
    width: 99%;
    height: 60%;
    float: left ;
    text-align: center;
    font-size: 1.5vw;
    vertical-align:auto;
}

</style>
