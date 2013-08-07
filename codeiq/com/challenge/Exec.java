package codeiq.com.challenge;
import lib.DeOut;

public class Exec {

  public static void main(String[] args) {
    Exec ex = new Exec();
    DeOut.disp(ex.countPrimeNumber(977));
  }

  public int countPrimeNumber(int num){
    int count = 0;
    // 0 1は素数ではないので0
    if(num==0 || num==1) return count;
    // 2は素数なので1
    if(num==2) return 1;
    // エラトステネスの篩でカウントする方法
    // 篩にかける配列をつくる。（配列の要素が2から始まるように調整する）
    int[] numbers = new int[num-1];

    for(int i=2;i<num;i++){
      numbers[i-2] = i;
    }
    // 現在の素数を格納する変数
    int currentPrime = 0;
    // numbers配列で素数以外を排除していく
    int index = 0;
    // numbers配列の最初の値を現在の素数とする
    currentPrime = numbers[index];
    // カウントアップする
    count = 1;
    // 配列の要素から素数だけを残していく
    while(index<numbers.length){
      // 最大値が必要なので要素内の最大値を格納する変数を定義
      int currentMax = 0;
      // 現在の素数（currentPrime）で割り切れるものは素数ではないので、-1として排除する。
      for(int k=0; k<numbers.length; k++){
        if(numbers[k] % currentPrime == 0){
          numbers[k] = -1;
        }
        // 最大値を都度比較して格納しておく。
        currentMax = Math.max(numbers[k], currentMax);
      }

      // 現在の素数の平方数が要素中の最大値を超えたら、配列内の非素数の排除処理はおわる。
      if(currentMax < Math.pow(currentPrime, currentPrime)) break;

      // ここからの処理は次の素数を決める処理
      boolean flg = true;
      while(flg){
        // 非素数以外であれば、次の素数とする。
        if(numbers[index+1] > -1){
          currentPrime = numbers[index+1];
          break;
        }else{
          // 検索するインデックスをすすめる
          index++;
        }
      }
      // 素数カウントを1つ進める。
      count++;
    }

    // 配列内の残った素数の要素数とcountを合算すると素数の数になる
    for(int i=0;i<numbers.length;i++){
      // 非素数は-1なのでそれ以外が素数としてカウント
      if(numbers[i]>-1) count++;
    }
    // 合計した結果
    return count;
  }

}
