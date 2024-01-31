// src/main/resources/static/js/battle.js


// Ajaxを使用してバトル情報を更新する
function updateBattle() {
    $.ajax({
        type: 'POST',
        url: '/update',  // <- /battle/update ではなく /update に修正
        dataType: 'json',
        success: function(response) {
            // サーバーからのレスポンスに基づいて画面を更新
            $('#battleMessage').text(response.battleMessage);
            $('.en_hp_detail span').text(response.enemyHP);
            $('.my_hp_detail span').text(response.playerHP);
            // 他にも必要な情報があれば同様に更新
        },
        error: function(error) {
            console.error('Error updating battle: ' + error);
        }
    });
}


// バトル攻撃を実行する
function attack(attackNumber) {
    $.ajax({
        type: 'POST',
        url: '/battle/attack',  // サーバーサイドの攻撃処理を行うエンドポイント
        data: { attackNumber: attackNumber },
        dataType: 'json',
        success: function(response) {
            // サーバーからのレスポンスに基づいて画面を更新
            $('#battleMessage').text(response.battleMessage);
            $('.en_hp_detail span').text(response.enemyHP);
            $('.my_hp_detail span').text(response.playerHP);
            // 他にも必要な情報があれば同様に更新
        },
        error: function(error) {
            console.error('Error executing attack: ' + error);
        }
    });
}

// ページロード時にバトル情報を更新
$(document).ready(function() {
    updateBattle();
});

// 定期的にバトル情報を更新（例: 5秒ごと）
setInterval(updateBattle, 5000);
