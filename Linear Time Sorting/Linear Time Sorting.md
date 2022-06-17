# Linear Time Sorting
前面實作的幾種排序演算法中，時間複雜度最快的為Merge Sort，在Worst case情況下可以達到O(nlogn)，事實上，在需要兩兩比較大小的排序演算法中，O(nlogn)為此種演算法的下界。也就是說，當一個排序演算法需要進行比較大小的步驟，此演算法的時間複雜度無法比O(nlogn)還快，詳細證明會放在medium，這邊就先略過。

這邊要介紹的三種演算法，由於沒有兩兩比較大小的步驟，因此時間複雜度最快都可以達到O(n)，也就是linear Time Sorting。


