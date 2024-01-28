// Ajaxを使用してバトル情報を更新する
function updateBattle() {
    $.ajax({
        type: 'POST',
        url: '/battle/update',  // サーバーサイドの更新処理を行うエンドポイント
        dataType: 'json',
        success: function(response) {
            // サーバーからのレスポンスに基づいて画面を更新
            $('#battleMessage').text(response.battleMessage);
            $('#enemyHP').text(response.enemyHP);
            $('#playerHP').text(response.playerHP);
            // 他にも必要な情報があれば同様に更新
        },
        error: function(error) {
            console.error('Error updating battle: ' + error);
        }
    });
}
