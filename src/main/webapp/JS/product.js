function minus(id) {
    var product = document.getElementById(id);
    var temp = +product.innerHTML - 1;
    if (temp < 0) {
        temp = 0;
    }
    product.innerHTML = temp;
}

function plus(id) {
    var product = document.getElementById(id);
    var temp = +product.innerHTML + 1;
    if (temp > 20) {
        temp = 20;
    }
    product.innerHTML = temp;
}

function buy(id) {
    var productId = document.getElementById(id + "code").innerHTML;
    var productQuantity = document.getElementById(id).innerHTML;

    $.ajax({
        url: "./CartServletMulti",
        type: "POST",
        data: {productId: productId, productQuantity: productQuantity},
        dataType: "html", success: function (html) {
            location.reload();
        }
    });
}

