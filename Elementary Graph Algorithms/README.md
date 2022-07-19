# Breadth-First Search：O(V+E)
> 首先從原點（source）開始，走訪與原點相鄰且未被記錄的節點進行記錄  
> 接著從這些剛被記錄的節點中挑一個節點重複進行上述動作直到走訪完整張圖

BFS 演算法可以幫助我們記錄從起點到任意一點的距離以及走訪的路線，和等等要介紹的 DFS 差異在於 BFS 會將同一層級的節點走訪完後才會前往下一層級，因此整個圖的尋訪過程是會逐漸加寬的，前面提到會走訪節點並記錄與其相鄰之節點，當一個節點被記錄時，會將此節點放入佇列（Queue），而當 BFS 要進到下一層級挑選節點時，則會從佇列選擇出要走訪的節點（FIFO）。
- Pseudocode：（BFS）

<img width="500" alt="截圖 2022-07-10 下午2 44 47" src="https://user-images.githubusercontent.com/103521272/178134318-43532f7b-b7b3-430f-8081-3517de8555c3.png">

d[] 是用來儲存節點與根節點的距離，π[] 則是用來儲存父節點，若是 π[0] = 1，表示是經過節點1才到達節點0的，color[]用來儲存節點的狀態，分為白、黑、灰，分別代表尚未走訪、走訪完畢以及正在走訪。  

首先從根節點開始走訪，標示根節點為走訪中並加入先進先出的佇列，佇列放入的為走訪中的節點。接著在 while 迴圈中，假如佇列不為空的情況下，也就是還有節點未被走訪完畢，取出佇列的第一個節點並找出其相鄰節點，若是相鄰節點尚未被走訪（白），則標示此相鄰節點為走訪中（灰）並加入佇列，而此節點的 d 、 π 分別為剛剛佇列的第一個節點的 d+1 以及剛剛佇列的第一個節點，最後當每一個相鄰節點都被確認狀態後，則將剛剛佇列的第一個節點標示為走訪完畢（黑）。

- Java：（BFS）
<img width="500" alt="截圖 2022-07-10 下午3 15 06" src="https://user-images.githubusercontent.com/103521272/178135207-f4cd0981-39c4-41e5-91d2-533900552417.png">

Adj[] 為鄰接串列陣列（adjacency-list representation），此陣列的每一個元素代表一個 LinkedList，也就是一個節點，用來儲存與此節點相連的節點，以此方法來完成圖的實現。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-10 下午3 31 05" src="https://user-images.githubusercontent.com/103521272/178135533-fec3994f-bddc-48ec-9a91-e79e5576b876.png">

<img width="500" alt="截圖 2022-07-10 下午3 31 52" src="https://user-images.githubusercontent.com/103521272/178135547-8d4578c7-07da-4606-844f-3a7087059d70.png">

# Depth-First-Search：O(V+E)
> 首先從原點（source）開始，挑選一個未被記錄的相鄰節點進行遞迴呼叫 DFS-visit
> 當遞迴停止表示從此相鄰節點延伸出的路線已無法再加深，接著挑選下一個未被記錄的相鄰節點進行遞迴呼叫 DFS。
> 之後依此類推直到確認過每一個相鄰節點，若是在 DFS-visit 後仍存在未被走訪的節點，則會因為 DFS 的呼叫而走訪到

DFS 的特點在於尋訪相鄰節點時，並不會像 BFS 一樣尋訪完同一層級的所有相鄰節點才進到下一層，而是在尋訪其中一個相鄰節點時繼續尋訪此節點的相鄰節點，直到此路線到達盡頭後才繼續走訪同一層級的其他相鄰節點，在底下的程式實作以及虛擬碼中也會紀錄節點開始走訪的時間以及結束走訪的時間，而在後面要介紹的兩種演算法則是從 DFS 的特性延伸出來的。

- Pseudocode：（DFS）

<img width="500" alt="截圖 2022-07-10 下午4 15 49" src="https://user-images.githubusercontent.com/103521272/178136938-78e6c0cd-bbba-4f57-82a1-9578ffb0b13b.png">

d[] 是用來儲存開始走訪的時間，f[]是用來儲存走訪完畢的時間，π[] 則是用來儲存父節點，若是 π[0] = 1，表示是經過節點1才到達節點0的，color[]用來儲存節點的狀態，分為白、黑、灰，分別代表尚未走訪、走訪完畢以及正在走訪。  

DFS 會檢查每一個節點，若是節點尚未被走訪，則對此節點執行 DFS-visit，此方法確保圖中的每一個節點都能被走訪到。首先對第一個節點執行 DFS-visit，將此節點標示為正在走訪並記錄其開始走訪的時間，接著找出未被尋訪的相鄰節點執行 DFS-visit，當此相鄰節點所延伸出的路線到達盡頭，則找下一個未被尋訪的相鄰節點執行 DFS-visit，依此類推，當相鄰節點都檢查完時，則將此節點標示為走訪完畢並記錄完成走訪時間。接著又會回到 DFS 的 for 迴圈，若是存在節點是剛剛第一個節點延伸出的路線中未被尋訪到的，則此 for 迴圈會找出此節點並執行 DFS-visit，直到所有節點被檢查完後演算法執行結束。


- Java：（DFS）

<img width="500" alt="截圖 2022-07-10 下午4 17 11" src="https://user-images.githubusercontent.com/103521272/178136981-701cec45-a29c-44a8-b31a-29c7d2e16cc3.png">

和 BFS 一樣，Adj[] 為鄰接串列陣列（adjacency-list representation），此陣列的每一個元素代表一個 LinkedList，也就是一個節點，用來儲存與此節點相連的節點。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-10 下午5 01 24" src="https://user-images.githubusercontent.com/103521272/178138295-3dad26e0-fc77-4438-a71a-b01cfb956f24.png">

<img width="500" alt="截圖 2022-07-10 下午5 01 54" src="https://user-images.githubusercontent.com/103521272/178138302-bec4b38a-f6c5-47e8-8335-2489ea368ca3.png">

# Topological Sort：O(V+E)
>用來排序有向圖中節點的排序方法  
>目的是為了將節點依照邊的先後順序進行排序

拓墣排序是從 DFS 延伸出來的排序法，經過此演算法排序之後，每一個節點的箭頭只會指向後方節點，而不會指往前方的節點，在介紹虛擬碼之前，要先對 DFS 中的邊的分類進行介紹，DFS 的邊可以分成以下幾種：  
1. Tree Edges：父節點連接到子節點
2. Back Edges：連結到自己本身、父節點、父節點的父節點⋯⋯
3. Forward Edges：連結到子節點的子節點⋯⋯
4. Cross Edges：連結到另一棵 DFS tree，可以理解成除了以上三種的邊  

我們也可以從開始走訪/走訪完畢時間來分類這四種邊，從前面對 DFS 的介紹可以發現父節點的時間範圍一定比子節點要長且涵蓋子節點的時間範圍，因此假設現在有一條邊，我們可以觀察邊的起點和終點來判斷分類，若起點為寬區間且涵蓋終點的區間，則為 Tree Edges 或是 Forward Edges，若起點為窄區間且被終點所涵蓋，則為 Back Edges，最後若是起點和終點的區間沒有交集，則為 Cross Edges（在 DFS 中，則代表起點是被 DFS 的 for 迴圈所呼叫）。

回到 Topological Sort，前面說到 Topological Sort 會使每一個節點的箭頭只會指向後方節點，而不會指往前方的節點，由此可以知道 input graph 不能夠存在 Back Edges，否則無論如何排序，仍會形成迴路。

- Pseudocode：（Topological Sort）
<img width="500" alt="截圖 2022-07-11 下午3 06 11" src="https://user-images.githubusercontent.com/103521272/178207697-35235777-508b-4ae5-9118-5e1dad50844d.png">

排序的首先為執行 DFS 並記錄結束時間，在執行過程中，當有節點結束走訪時，要插入在 LinkedList 的最前方，當所有節點被放入 LinkedList 後，最後反轉整個 LinkedList 就會得到 output。
在 graph 中，當父節點連接到子節點時，表示父節點屬於子節點的先行活動，因此在 Topological Sort 中父節點會被排到子節點前面，利用結束時間來做排序便可以完成此目標。用開始時間作為排序依據在 Cross Edge 可能會造成先行活動排在子節點後面。

- Java：（Topological Sort）
<img width="500" alt="截圖 2022-07-11 下午3 22 49" src="https://user-images.githubusercontent.com/103521272/178210216-3e0a522c-074d-449f-8339-b39437a4e44a.png">

在實作上我並沒有使用 LinkedList 而是 Stack，利用 Stack LIFO 的特性取代反轉 LinkedList 我覺得比較方便。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-11 下午3 27 48" src="https://user-images.githubusercontent.com/103521272/178211032-e28ec09c-e8b9-4e8c-9853-93f5be637a2d.png">

<img width="500" alt="截圖 2022-07-11 下午3 30 22" src="https://user-images.githubusercontent.com/103521272/178211491-3780a176-d300-4e4e-90e0-1d4d3deda679.png">

<img width="500" alt="截圖 2022-07-11 下午3 29 27" src="https://user-images.githubusercontent.com/103521272/178211315-c019c047-dae6-410e-9d27-12437c78df25.png">

<img width="500" alt="截圖 2022-07-11 下午3 29 41" src="https://user-images.githubusercontent.com/103521272/178211400-7be84744-ab4c-480e-8daa-6ed4c7d83ad2.png">

# Strongly Connected Components：O(V+E)
>SCC 表示區域內的點可以互通，假設區域內有 a, b, c 三個點，若此區域為 SCC ，則 a, b, c 可以透過區域內的邊相互連接  
>當我們對原本的圖執行 SCC 後便會形成 DAG，那麼就會使後面的問題處理簡單許多

和剛剛的 Topological Sort 不一樣的地方在於 SCC 的執行建立在 graph 中存在 Back Edges 的條件下，由於形成 SCC 的條件為封閉迴路，因此 Back Edges 是必要的，而 Topological Sort 則要求 graph 不能存在 Back Edges。

- Pseudocode：（SCC）

 <img width="500" alt="截圖 2022-07-11 下午3 46 00" src="https://user-images.githubusercontent.com/103521272/178214263-e94be7b1-f55e-49d8-92d5-ce6e5c4c35d4.png">

首先對 graph 執行一次 DFS 並記錄走訪完畢的時間，接著將 graph 中的每一條邊反轉得到另一張圖，對這張新的圖再執行一次 DFS，要注意的是節點走訪的順序會依照第一次 DFS 的走訪完畢時間排序，也就是說，走訪完畢時間最晚的會最早被第二次的 DFS 走訪。執行完第二次的 DFS 所得出的每個 DFS Tree 就是 SCC。

我在網路上有看到一個對於反轉每個邊較為直觀的解釋，這個解釋的意思是說如果輸入的 graph 存在封閉迴路，那麼一定存在一個區域它的邊是全部指向區域外的，而執行完第一次 DFS 後最後結束的節點會存在於區域內，當我們反轉每個邊且依照第一次 DFS 結束時間進行第二次 DFS 時，可以確保起點在這個區域內，此時原本指向其他區域的邊會因為剛剛的反轉變成全部指向區域內，如此可以保證區域內的節點會自成一個 DFS Tree。

- Java：（SCC）

<img width="500" alt="截圖 2022-07-11 下午4 06 30" src="https://user-images.githubusercontent.com/103521272/178217699-5f882b22-f37c-4f1a-a46c-7ef7ff6b4f08.png">

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-11 下午4 07 48" src="https://user-images.githubusercontent.com/103521272/178217892-42472e97-42dd-43f6-a1bf-052e4e6e1f9d.png">
<img width="500" alt="截圖 2022-07-11 下午4 08 00" src="https://user-images.githubusercontent.com/103521272/178217942-895beda0-c634-483a-adcc-d50778247d54.png">

# Minimum Spanning Tree：  Kruskal's : O(ElogE)  Prim's : O(VlogV+ElogV)
> 在一個有權重的無向圖中，試圖用最少的邊找出一個樹，使得圖中的每一個節點都能被這個樹所連接
> 由於要利用最少的邊，因此此樹不存在封閉迴圈，且找出來的數可能不只一個
> 每條邊皆有其權重，總和權重最小的樹我們就叫做 Minimum Spanning Tree

透過以上敘述，我們可以知道要形成一個 spanning tree 需要節點數減一個邊來完成，而要找出總和權重最小的樹的重點在於如何挑選形成樹的邊，以下分別介紹兩種 spanning tree 的演算法，第一種是 Kruskal's algorithm，每一次迭代採取選邊策略，第二種則是 Prim's algorithm，在每次迭代採取的則是選擇節點策略。

- Pseudocode：（Kruskal's algorithm）

<img width="500" alt="截圖 2022-07-14 上午8 47 43" src="https://user-images.githubusercontent.com/103521272/178861076-6b991ac3-9b20-4b4a-b611-b2c981c75650.png">

Kruskal 的核心概念在於從權重最小的邊開始遍歷，如果邊所連接的兩個節點尚未被其他邊所連接，表示目前選擇的邊是可行的。為了要在每一次選擇邊時都能先檢查邊所連接的兩個節點是否被其他邊所連接，這邊會利用到 Disjoint set 的 Make-set, Union, Find-set 方法，可以看到第二、三行，首先將每一個節點視為一個獨立的集合，接著排序邊的權重並從最小的邊開始走訪，第六行的 Find-set 會取得集合中的代表元素，如果邊連接的兩個節點其代表元素不相等，則將兩者的集合合併，也就是改變其中一個集合的代表元素。

- Java：（Kruskal's algorithm）

<img width="500" alt="截圖 2022-07-14 上午9 03 25" src="https://user-images.githubusercontent.com/103521272/178862561-1771ed2d-164c-4afa-934e-5a045af11aea.png">

我首先宣告了可以存放 Edge 物件的陣列，也就是用來存放圖中的每個邊，接著 implements Comparable 介面並 override compareTo 方法來讓後面的排序可以依照邊的權重作為排序標準（完整程式碼放在檔案），而 subset 陣列則是用來儲存每一個集合，透過 parent attribute 來儲存集合的代表。  

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-14 上午9 42 52" src="https://user-images.githubusercontent.com/103521272/178869138-4c3c3ac8-c799-450a-9070-a858ff23ecaa.png">

<img width="500" alt="截圖 2022-07-14 上午9 49 21" src="https://user-images.githubusercontent.com/103521272/178873133-50ac9a5f-f828-452f-9fe1-a52894a11748.png">

- Pseudocode：（Prim's algorithm）

<img width="500" alt="截圖 2022-07-14 上午9 51 02" src="https://user-images.githubusercontent.com/103521272/178874346-87621fac-1e96-4045-a41a-4968aca56aeb.png">

Prim 的核心概念則是在於每次迭代選擇 key 值最小的節點，而每個節點的 key 值則是透過邊的權重決定，隨著迭代次數增加，延伸出的邊會越多，每個節點的 key 值可能不斷更新。一開始除了 source 每個節點的 key 值皆為一個極大值，然後將每個節點都放入 priority queue，接著選擇 key 值最小的節點，也就是 source，對 source 延伸出來的邊做 relaxation ，假設 source 延伸出兩條線分別連到節點 1、3，權重分別為 4、6，則執行完 8~11 行後 key[1] 和 key[3] 就會變成 4 和 6，一直到節點從 priority queue 移除之前， key 值都是可能變動的，由於是無向圖，所以不會發生節點從 priority queue 移除之後卻發現 key 值可以更低的情況。

- Java：（Prim's algorithm)

<img width="500" alt="截圖 2022-07-14 上午10 08 32" src="https://user-images.githubusercontent.com/103521272/178882613-c73e58df-8a08-47fb-9171-e5a540d67889.png">
 
在 53~55 行由於改變 key 值後如果沒有進行其他處理，priority queue 中的順序是不會變的，因此必須先 remove 原本的 key 值，再加入更新後的 key 值。

以下是主程式碼以及執行結果：

<img width="500" alt="截圖 2022-07-14 上午10 26 52" src="https://user-images.githubusercontent.com/103521272/178884826-161f8af4-e423-40a6-bc27-90402978e625.png">

<img width="500" alt="截圖 2022-07-14 上午10 27 28" src="https://user-images.githubusercontent.com/103521272/178884887-cd75168e-3956-4e1b-9753-42dd1bd4163b.png">

# Bellman Ford：O(VE)
>對所有 n 個節點做 n-1 輪的鬆弛
>每一次鬆弛都可能改變之前已經計算好的路徑

首先要介紹的第一個最短路徑演算法為 Bellman Ford Algorithm ，和等等要介紹的 Dijkstra Algorithm 不一樣的是 Bellman Ford Algorithm 可以處理帶有負權重的邊的圖，以下會詳細解釋。

- Pseudocode：（Bellman Ford）

<img width="500" alt="截圖 2022-07-19 上午8 49 16" src="https://user-images.githubusercontent.com/103521272/179640558-11bf8f52-5cbb-4494-aba3-17a388ef75cb.png">

initialize 主要是將每個點與 source 的距離（d[]）設定成 sentinel（除了 source 本身），後續再透過 relax 改變距離。接著要進行第一輪的鬆弛，執行方式就是走訪每個邊，如果邊的終點目前的距離比邊的起點加上邊的權重大（d[v] > d[u] + w），那麼就將終點的距離改成邊的起點加上邊的權重，每一個邊計算完為執行一輪，由於我們有 n 個節點，因此要執行 n-1 輪。

假設現在有兩條邊，分別是 1 到 2 和 2 到 3，如果今天是先走訪 2 到 3 再走 1 到 2，那麼一開始走訪 2 到 3 的邊時會因為 1 到 2為 sentinel 而無法進行 relax，萬一後面走訪到 1 到 2 時節點 2 與 source 的距離由於 relax 降低了，此時就會形成 2 到 3 沒被更新到的狀況，因此 relax 要重複做好幾輪才能得到最佳解。  

n-1 輪的鬆弛結束後，接著要再重新走訪每個邊，如果還能進行 relax，也就是 d[v] > d[u] + w，代表圖中有出現負權重迴圈，每一次走訪時的最短距離都會被更新，無法找出最佳解。

- Java：（Bellman Ford）

 <img width="500" alt="截圖 2022-07-19 上午9 33 58" src="https://user-images.githubusercontent.com/103521272/179644952-93e7d6d2-0732-49dd-ae12-3ecb46a87f6a.png">


以下是主程式碼及執行結果：

<img width="500" alt="截圖 2022-07-19 上午9 35 47" src="https://user-images.githubusercontent.com/103521272/179645155-41ec5e44-83a2-4f3b-bc3d-15e3786bad17.png">

<img width="500" alt="截圖 2022-07-19 上午9 35 29" src="https://user-images.githubusercontent.com/103521272/179645122-fa93589f-44bd-4c65-8c10-f052c069800b.png">

