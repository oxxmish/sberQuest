let cvs = document.getElementById("canvas");
let head = document.getElementById("logo");
cvs.width = head.offsetWidth * 0.7;
cvs.height = window.innerHeight - head.offsetHeight - 2;
let ctx = cvs.getContext('2d');

let value_dice = document.getElementById("dice_value");

let current_dice_value = value_dice.innerText;
let current_turn = 1;



console.log(value_dice.innerText);
console.log(head.offsetHeight);

let UpScene = new Image();
UpScene.src = "images/UpScene1.png";

function draw_product(init_x, init_y, radius, color) 
{
    ctx.fillStyle = color;
    ctx.beginPath();
    ctx.arc(init_x, init_y, radius, 0, (Math.PI/180)*360);
    ctx.fill();
}

function draw() 
{
    if(current_dice_value )
    value_dice = document.getElementById("dice_value");
    // console.log(value_dice.innerText);
    cvs.width = head.offsetWidth * 0.7;
    cvs.height = window.innerHeight * 0.9025;
    let field_size;
    if(cvs.width > cvs.height)
        // field_size = cvs.height - cvs.height * 0.2;
        field_size = cvs.height - cvs.height * 0.1;
    else
        // field_size = cvs.width - cvs.width * 0.2;
        field_size = cvs.width - cvs.width * 0.1;

    let top_border_field = (cvs.height - field_size) / 2 - cvs.height * 0.05;
    let bottom_border_field = (cvs.height - field_size) / 2 - cvs.height * 0.05 + field_size;
    let left_border_field = (cvs.width - field_size) / 2;
    let right_border_field = (cvs.width - field_size) / 2 + field_size;
    ctx.strokeRect(left_border_field, top_border_field, field_size, field_size);

    
    


    // ctx.beginPath();
    // ctx.moveTo(cvs.width / 2,0);
    // ctx.lineTo(cvs.width / 2,cvs.height);
    // ctx.closePath();
    // ctx.stroke();

    // ctx.beginPath();
    // ctx.moveTo(0,cvs.height / 2);
    // ctx.lineTo(cvs.width,cvs.height / 2);
    // ctx.closePath();
    // ctx.stroke();

    // ctx.beginPath();
    // ctx.moveTo(0,cvs.height / 2 - cvs.height * 0.05);
    // ctx.lineTo(cvs.width,cvs.height / 2  - cvs.height * 0.05);
    // ctx.closePath();
    // ctx.stroke();



    let radius = field_size * 0.070;
    let step = 1.15 * radius;
    let top_center_y = top_border_field + cvs.height * 0.01 + radius;
    let top_center_x = cvs.width / 2;

    let bottom_center_y = bottom_border_field - cvs.height * 0.01 - radius;
    let bottom_center_x = cvs.width / 2;

    let left_center_y = cvs.height / 2 - cvs.height * 0.05;
    let left_center_x = left_border_field + cvs.height * 0.01 + radius;

    let right_center_y = cvs.height / 2 - cvs.height * 0.05;
    let right_center_x = right_border_field - cvs.height * 0.01 - radius;

    ctx.beginPath();
    ctx.moveTo(left_border_field + radius, top_border_field + radius);
    ctx.lineTo(right_border_field - radius, bottom_border_field - radius);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(left_border_field + radius, bottom_border_field - radius);
    ctx.lineTo(right_border_field - radius, top_border_field + radius);
    ctx.closePath();
    ctx.stroke();

    // top
    draw_product(top_center_x + step, top_center_y, radius, 'blue');
    draw_product(top_center_x - step, top_center_y, radius, 'green');
    draw_product(top_center_x + 2 * step + radius, top_center_y, radius, 'red');
    draw_product(top_center_x - 2 * step - radius, top_center_y, radius, 'yellow');


    // bottom
    draw_product(bottom_center_x + step, bottom_center_y, radius, 'pink');
    draw_product(bottom_center_x - step, bottom_center_y, radius, 'orange');
    draw_product(bottom_center_x + 2 * step + radius, bottom_center_y, radius, 'purple');
    draw_product(bottom_center_x - 2 * step - radius, bottom_center_y, radius, 'black');

    // left
    draw_product(left_center_x, left_center_y + step, radius, 'cyan');
    draw_product(left_center_x, left_center_y - step, radius, 'coral');
    draw_product(left_center_x, left_center_y + 2 * step + radius, radius, 'springgreen');
    draw_product(left_center_x, left_center_y - 2 * step - radius, radius, 'slategray');

    // left
    draw_product(right_center_x, right_center_y + step, radius, 'rebeccapurple');
    draw_product(right_center_x, right_center_y - step, radius, 'thistle');
    draw_product(right_center_x, right_center_y + 2 * step + radius, radius, 'crimson');
    draw_product(right_center_x, right_center_y - 2 * step - radius, radius, 'lawngreen');
    
    ctx.lineWidth = 2;
    // console.log(ctx.lineWidth)
    ctx.fillStyle = 'white';
    ctx.beginPath();
    ctx.arc(cvs.width / 2, cvs.height / 2 - cvs.height * 0.05, 1.5 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('ФИНИШ', cvs.width / 2 - 1 * radius, cvs.height / 2 - cvs.height * 0.05 + radius / 7, 2 * radius)
    ctx.fillStyle = 'white';

    // inner ring
    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 2 * radius, cvs.height / 2 - cvs.height * 0.05 + 2 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('2', cvs.width / 2 + 1.8 * radius, cvs.height / 2 - cvs.height * 0.05 + 2.3 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 2 * radius, cvs.height / 2 - cvs.height * 0.05 + 2 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('2', cvs.width / 2 - 2.2 * radius, cvs.height / 2 - cvs.height * 0.05 + 2.3 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 2 * radius, cvs.height / 2 - cvs.height * 0.05 - 2 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('2', cvs.width / 2 + 1.8 * radius, cvs.height / 2 - cvs.height * 0.05 - 1.7 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 2 * radius, cvs.height / 2 - cvs.height * 0.05 - 2 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('2', cvs.width / 2 - 2.2 * radius, cvs.height / 2 - cvs.height * 0.05 - 1.7 * radius)
    ctx.fillStyle = 'white';

    // outer ring
    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 3.65 * radius, cvs.height / 2 - cvs.height * 0.05 + 3.65 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('1', cvs.width / 2 + 3.4 * radius, cvs.height / 2 - cvs.height * 0.05 + 3.95 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 3.65 * radius, cvs.height / 2 - cvs.height * 0.05 + 3.65 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('1', cvs.width / 2 - 3.9 * radius, cvs.height / 2 - cvs.height * 0.05 + 3.95 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 3.65 * radius, cvs.height / 2 - cvs.height * 0.05 - 3.65 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('1', cvs.width / 2 + 3.4 * radius, cvs.height / 2 - cvs.height * 0.05 - 3.35 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 3.65 * radius, cvs.height / 2 - cvs.height * 0.05 - 3.65 * radius, 0.85 * radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = radius + "px serif";
    ctx.fillText('1', cvs.width / 2 - 3.9 * radius, cvs.height / 2 - cvs.height * 0.05 - 3.35 * radius)
    ctx.fillStyle = 'white';

    // start
    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 5.95 * radius, cvs.height / 2 - cvs.height * 0.05 + 5.95 * radius, radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('Старт', cvs.width / 2 + 5.35 * radius, cvs.height / 2 - cvs.height * 0.05 + 6.05 * radius, 1.5 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 5.95 * radius, cvs.height / 2 - cvs.height * 0.05 - 5.95 * radius, radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('Старт', cvs.width / 2 - 6.55 * radius, cvs.height / 2 - cvs.height * 0.05 - 5.8 * radius, 1.5 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 + 5.95 * radius, cvs.height / 2 - cvs.height * 0.05 - 5.95 * radius, radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('Старт', cvs.width / 2 + 5.4 * radius, cvs.height / 2 - cvs.height * 0.05 - 5.8 * radius, 1.5 * radius)
    ctx.fillStyle = 'white';

    ctx.beginPath();
    ctx.arc(cvs.width / 2 - 5.95 * radius, cvs.height / 2 - cvs.height * 0.05 + 5.95 * radius, radius, 0, (Math.PI/180)*360);
    ctx.stroke();
    ctx.fill();

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('Старт', cvs.width / 2 - 6.55 * radius, cvs.height / 2 - cvs.height * 0.05 + 6.05 * radius, 1.5 * radius)
    ctx.fillStyle = 'white';

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('И1', top_center_x - step, top_center_y)
    ctx.fillStyle = 'white';

    ctx.fillStyle = 'black';
    ctx.font = 0.5 * radius + "px serif";
    ctx.fillText('И2', top_center_x + step, top_center_y)
    ctx.fillStyle = 'white';

    requestAnimationFrame(draw);
}

UpScene.onload = draw;