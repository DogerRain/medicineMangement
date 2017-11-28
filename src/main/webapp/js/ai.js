var maxx = 20, maxy = 20, wincount = 5;
var count = 0;
var wins = [];
var meWin1 = [], aiWin1 = [];
meWin1[0] = 0; aiWin1[0] = 0;
var chessBoard = [];
for (var i = 0; i < maxx; ++i) {
    chessBoard[i] = [];
    for (var j = 0; j < maxy; ++j)
        chessBoard[i][j] = 0;
}
var turn = 2;
for (var i = 0; i < maxx; ++i) {
    wins[i] = [];
    for (var j = 0; j < maxy; ++j) {
        wins[i][j] = [];
    }
}


//妯�
for (var i = 0; i < maxx; ++i)
    for (var j = 0; j < maxy - wincount + 1; ++j) {
        for (var k = 0; k < wincount; ++k)
            wins[i][j + k][count] = true;
        ++count;
        meWin1[count] = 0; aiWin1[count] = 0;
    }
//绔�
for (var i = 0; i < maxy; ++i)
    for (var j = 0; j < maxx - wincount + 1; ++j) {
        for (var k = 0; k < wincount; ++k)
            wins[j + k][i][count] = true;
        ++count;
        meWin1[count] = 0; aiWin1[count] = 0;
    }
//45
for (var i = 0; i <= maxx - wincount; ++i)
    for (var j = maxy - 1; j >= wincount - 1; --j) {
        for (var k = 0; k < wincount; ++k)
            wins[i + k][j - k][count] = true;
        ++count;
        meWin1[count] = 0; aiWin1[count] = 0;
    }
//145
for (var i = 0; i <= maxx - wincount; ++i)
    for (var j = 0; j <= maxy - wincount; ++j) {
        for (var k = 0; k < wincount; ++k)
            wins[i + k][j + k][count] = true;
        ++count;
        meWin1[count] = 0; aiWin1[count] = 0;
    }
function aiRun(drawPointByAi) {
    var meWin = [];
    var aiWin = [];
    for (var i = 0; i < maxx; ++i) {
        meWin[i] = [];
        aiWin[i] = [];
        for (var j = 0; j < maxy; ++j) {
            meWin[i][j] = 0;
            aiWin[i][j] = 0;
        }
    }
    var max = 0, mi = 0, mj = 0;

    for (var i = 0; i < maxx; ++i)
        for (var j = 0; j < maxy; ++j) {
            if (chessBoard[i][j] == 0) {

                for (var k = 0; k < count; ++k) {
                    if (wins[i][j][k] == true) {
                        if (meWin1[k] == 1) meWin[i][j] += 200;
                        else if (meWin1[k] == 2) meWin[i][j] += 400;
                        else if (meWin1[k] == 3) meWin[i][j] += 2000;
                        else if (meWin1[k] == 4) meWin[i][j] += 10000;

                        if (aiWin1[k] == 1) aiWin[i][j] += 220;
                        else if (aiWin1[k] == 2) aiWin[i][j] += 420;
                        else if (aiWin1[k] == 3) aiWin[i][j] += 2100;
                        else if (aiWin1[k] == 4) aiWin[i][j] += 20000;
                    }
                }

                if (meWin[i][j] > max) {
                    max = meWin[i][j];
                    mi = i; mj = j;
                    console.log(i + " " + j)
                }
                else if (meWin[i][j] == max) {
                    if (aiWin[i][j] > aiWin[mi][mj]) {
                        mi = i; mj = j;
                        console.log(i + " " + j)
                    }
                }

                if (aiWin[i][j] > max) {
                    max = aiWin[i][j];
                    mi = i; mj = j;
                    console.log(i + " " + j)
                }
                else if (aiWin[i][j] == max) {
                    if (meWin[i][j] > meWin[mi][mj]) {
                        mi = i; mj = j;
                        console.log(i + " " + j)
                    }
                }

            }
        }
  //  alert(mi + " " + mj)
  //  aiRender(mi, mj);
    drawPointByAi(mi,mj);
    chessBoard[mi][mj] = 2;
    for (var k = 0; k < count; ++k) {
        if (wins[mi][mj][k] == true) {
            aiWin1[k]++;
            meWin1[k] = wincount + 1;
            if (aiWin1[k] == wincount) {
                alert('ai WIN');
                return;
            }

        }
    }
    turn = 1;

}
function aiRender(mi, mj) {
    chessBoard[mi][mj] = 2;
    $("#qipan").find('button[x=' + mi + '][y=' + mj + ']').css('background-color', 'blue');
}      
