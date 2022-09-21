<template>
<div class="section">
        <div class="teamImage">
            <img src="@/assets/crown.png" id="img_crown"/>
        </div>
        <div id="results" class="skills">Результаты</div>
        
        <div class="diagram" id="teams">
            <div v-if="logos[0] !== null" class="skillBLock">
                <div class="teamImage">
                    <img :src="img_path + 'team_logo_' + String(Number(logos[0]) + 1) + '.svg'" class="ms-auto" style="position: absolute; bottom: 55%; left: 10%;width: 5%;" />
                </div>
                <div id="leader_team_1" class="column" style="position:absolute;bottom:1%;left:1%;width:23.5%;background:rgb(246, 171, 129);">{{scores[0]}}</div>
            </div>
            <div v-if="logos[1] !== null" class="skillBLock">
                <div class="teamImage">
                    <img :src="img_path + 'team_logo_' + String(Number(logos[1]) + 1) + '.svg'" class="ms-auto" style="position: absolute; bottom: 55%; left: 35%;width: 5%;" />
                </div>
                <div id="leader_team_2" class="column" style="position:absolute;bottom:1%;left:25.5%;width:23.6%;background:rgb(196, 196, 215);">{{scores[1]}}</div>
            </div>
            <div v-if="logos[2] !== null" class="skillBLock">
                <div class="teamImage">
                    <img :src="img_path + 'team_logo_' + String(Number(logos[2]) + 1) + '.svg'" class="ms-auto" style="position: absolute; bottom: 55%; left: 59%;width: 5%;" />
                </div>
                <div id="leader_team_3" class="column" style="position:absolute;bottom:1%;left:50.1%;width:23.8%;background:rgb(188, 243, 197);">{{scores[2]}}</div>
            <div v-if="logos[3] !== null" class="skillBLock">
                <div class="teamImage">
                    <img :src="img_path + 'team_logo_' + String(Number(logos[3]) + 1) + '.svg'" class="ms-auto" style="position: absolute; bottom: 55%; left: 83.5%;width: 5%;" />
                </div>
                <div id="leader_team_4" class="column" style="position:absolute;bottom:1%;left:75%;width:24%;background:rgb(255, 223, 104);">{{scores[3]}}</div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import { SRC_PATH } from '../common_const.js'

export default {
  name: 'LeaderBoard',
  props: ['scores', 'logos'],
  data () {
    return {
        img_path: SRC_PATH,
    }
  },
  mounted: function () {
    console.log(this.logos);
      
  this.$nextTick(function () {
    let max = Math.max.apply(null, this.scores);
    document.getElementById("leader_team_1").animate([
        // keyframes
        {
            height: '0',
            opacity: '0'
        },
        {
            height: '0',
            opacity: '0'
        },
        {
            height: this.scores[0] / max * 50 + '%',
            opacity: '1'
        }
        ], {
        // timing options
        duration: 2500,
        iterations: 1
        });
    document.getElementById("leader_team_1").style.height = this.scores[0] / max * 50 + '%';
    document.getElementById("leader_team_2").animate([
        // keyframes
        {
            height: '0',
            opacity: '0'
            
        },
        {
            height: '0',
            opacity: '0'
        },
        {
            height: this.scores[1] / max * 50 + '%',
            opacity: '1'
        }
        ], {
        // timing options
        duration: 2500,
        iterations: 1
        });
    document.getElementById("leader_team_2").style.height = this.scores[1] / max * 50 + '%';
    document.getElementById("leader_team_3").animate([
        // keyframes
        {
            height: '0',
            opacity: '0'
        },
        {
            height: '0',
            opacity: '0'
        },
        {
            height: this.scores[2] / max * 50 + '%',
            opacity: '1'
        }
        ], {
        // timing options
        duration: 2500,
        iterations: 1
        });
    document.getElementById("leader_team_3").style.height = this.scores[2] / max * 50 + '%';
    document.getElementById("leader_team_4").animate([
        // keyframes
        {
            height: '0',
            opacity: '0'
        },
        {
            height: '0',
            opacity: '0'
        },
        {
            height: this.scores[3] / max * 50 + '%',
            opacity: '1'
        }
        ], {
        // timing options
        duration: 2500,
        iterations: 1
        });
    document.getElementById("leader_team_4").style.height = this.scores[3] / max * 50 + '%';
  })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#img_crown{
    left: 45%;
    position: relative;
    height: 120%;
    width: 10%;
}

#results{
    left: 34%;
    position: relative;
}
    .teamImage {
        /* display: block; */
        padding-bottom: 1%;
        height: 15%;
        width: 100%;
    }
    .section {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        /* display: flex; */
        /* align-items: center;
        flex-direction: column; */
        border: solid black 2px;
        width: 60%;
        height: 60%;
        border-radius: 10px;
        background: white;
        z-index: 10;
    }
    .skills {
        font-weight: bold;
        text-transform: uppercase;
        color: black;
        font-size: 3vw;
        margin-bottom: 1%;
        float: left;
    }
    .diagram {
        /* display: flex; */
        /* justify-content: space-around;
        align-items: center; */
        width: 100%;
        height: 82%;
    }
    .skillBLock {
        height: 300px;
        /* display: flex; */
        /* justify-content: flex-end;
        align-items: center;
        flex-direction: column; */
        float: left;
        text-align: center;
        color: white;
        font-size: 3vw;
    }
    .column {
        /* display: flex; */
        /* justify-content: center;
        align-items: center; */
        width: 235px;
    }
    /* .skillBLock:first-child .column {
        background: rgba(76, 28, 214, 0.35);
        height: 50%;
        animation: appFir 2s 1;
    }
    .skillBLock:nth-child(2) .column {
        background: rgba(214, 28, 28, 0.68);
        height: calc(350px / 100 * 30);
        animation: appSec 2s 1;
    }
    .skillBLock:nth-child(3) .column {
        background: rgba(28, 180, 214, 0.35);
        height: calc(350px / 100 * 40);
        animation: appThi 2s 1;
    }
    .skillBLock:last-child .column {
        background: rgba(117, 205, 6, 0.65);
        height: calc(350px / 100 * 20);
        animation: appFou 2s 1;
    } */
    .column span {
        
        color: #fff;
        font-weight: bold;
        font-size: 20px;
        animation: app 3s 1;
    }
    .name {
        text-transform: uppercase;
        color: black;
        font-weight: bold;
        font-size: 25px;
        margin-top: 10px;
    }
    /* @keyframes appFir {
        0% {
            height: 0;
        }
        20% {
            height: 0;
        }
        100% {
            height: 50%;
        }
    } */
    /* @keyframes appSec {
        0% {
            height: 0;
        }
        20% {
            height: 0;
        }
        100% {
            height: calc(350px / 100 * 30);
        }
    }
    @keyframes appThi {
        0% {
            height: 0;
        }
        20% {
            height: 0;
        }
        100% {
            height: calc(350px / 100 * 40);
        }
    }
    @keyframes appFou {
        0% {
            height: 0;
        }
        20% {
            height: 0;
        }
        100% {
            height: calc(350px / 100 * 20);
        }
    } */
    @keyframes app {
        0% {
            opacity: 0;
        }
        70% {
            opacity: 0;
        }
        100% {
            opacity: 1;
        }
    }
</style>
