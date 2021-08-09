enumFrom :: Int -> Int ->[Int]
enumFrom 1 1 = [1]
enumFrom 1 n = [1..n]




(++) :: [a] -> [a] -> [a]
(++) [] l = l
(++) l [] = l
(++) (h:t) (x:xs) = h: (++) t (x:xs)

(!!) :: [a] -> Int -> a
(!!) [] n = []
(!!) (h:t) n | n == 0 = h
             | otherwise = (!!) t (n-1)

reverse' :: [a] -> [a]
reverse'   []    = []
reverse' (h:t)   =  reverse' t ++ [h]

take' :: Int -> [a] -> [a]
take' 0 _     = []
take' _ []    = []
take' x (h:t) = h: take'(x-1) t

drop :: Int -> [a] -> [a]
drop 0   l    = l
drop _  []    = []
drop x (h:t)  = drop (x-1) t 

zip :: [a] -> [b] -> [(a,b)]
zip [] _ = []
zip _ [] = []
zip (h:t) (x:xs) = (h,x): zip t xs

elem :: Eq a => a -> [a] -> Bool
elem n [] = False 
elem n (h:t) | n==h = True 
             | otherwise = elem n t  

replicate :: Int -> a -> [a]
replicate 0 _ = []
replicate x n = n: replicate (x-1) n 

interspace :: a -> [a] -> [a]
interspace _ [a] = [a] 
interspace _ [] = []
interspace n (h:t) = h:n: interspace n t 

--12)???????????????????????????????????
group :: Eq a => [a] -> [[a]]
group [] = [] 
group (h1:h2:t) | h1==h2 = [[h1,h2]] 
                | otherwise group t  

--18)
issubsequenoff :: Eq a => [a] -> [a] -> Bool
issubsequenoff [] _ = True
issubsequenoff _ [] = False
issubsequenoff (h:t) (x:xs) = h==x && issubsequenoff t xs || issubsequenoff (h:t) xs


nub' :: Eq a => [a] -> [a] 
nub' [] = []
nub' (h:t) | elem h t = nub' t 
           | otherwise = h:nub' t

delete :: Eq a => a -> [a] -> [a]
delete _ [] = []
delete n (h:t) | n==h = t
               | n/=h = h:delete t 

(//) :: Eq a => [a] -> [a] -> [a] 
(//) [] _ = []
(//) l [] = l
(//) (h:t) (x:xs) = (//) (delete  x (h:t)) xs
                  
temrepetidos' :: Eq => [a] -> Bool
temrepetidos' [_] = False
temrepetidos' (h:t) | elem h t = True
                    | otherwise = temrepetidos' t 

algarismos' :: [Char] -> [Char]
algarismos' [] = []
algarismos' (h:t) | elem h [1..9] = h: algarismos' t 
                  | otherwise = algarismos' t 

-- 31)

posimpares' :: [a] -> [a] 
posimpares' [] = []
posimpares' [x] = []
posimpares' (h:s:t) = s:posimpares' t 

issorted' :: Ord a=> [a] -> Bool
issorted' [] = False
issorted' [x] = True
issorted' (x:y:t) = x <= y && issorted' y:t  

isort' :: Ord => [a] -> [a] 
isort' [] = []
isort' (h:t) = insert h (isort' t) 

menor' :: String -> String -> Bool
menor' _ "" = False
menor' "" _ = True
menor' l1 l2 | length l1 < length l2 = True
             | otherwise = False  


elemMSET' :: Eq => a -> [(a,Int)] ->  Bool
elemMSET' _ [] = False
elemMSET' n ((x,y):t) = n==x || elemMSET' n t

lenghtMSET' :: [(a,Int)] -> [a]
lenghtMSET' [] = 0
lenghtMSET' ((x,y):t) = y + lenghtMSET' t  

convertMSET' :: [(a,Int)] -> [a]
convertMSET' [] = []
convertMSET' ((x,1):t) =  x:convertMSET' t
convertMSET' ((x,y):t) = x:convertMSET' ((x,y-1):t)

insereMSET' :: Eq a => a -> [(a,Int)] -> [(a,Int)]
insereMSET' n [] = [(n,1)]
insereMSET' n ((x,y):t) | n == x = ((x,y+1):t)
                        |otherwise = insereMSET' n t 


removeMSET' :: Eq a => a -> [(a,Int)] -> [(a,Int)]
removeMSET' n [] = []
removeMSET' n ((x,y):t) | n == x = t
                        | otherwise = (x,y):removeMSET' n t 

-- 41 )

constroiMSET'  :: Ord a => [a] -> [(a,Int)]
constroiMSET' [] = []
constroiMSET' (h:t) = insereMSET' h (constroiMSET' t) 

parttiotioneithers' :: [Either a b] -> ([a],[b])
parttiotioneithers' [] = []
parttiotioneithers' (h:t) = (parttiotionlefts (h:t),parttitionRights (h:t))
where           partiotionlefts [] = []
                partitionLefts ((Left x):ls) = x:partitionLefts ls
                partitionLefts ((Right x):ls) = partitionLefts ls
                partitionRights [] = []
                partitionRights ((Left x):ls) = partitionRights ls
                partitionRights ((Right x):ls) = x:partitionRights ls 

--44)

data Movimento = Norte | Sul | Este | Oeste
    deriving Show 

    posicao:: (Int,Int) -> [Movimento] -> (Int,Int)
    posicao (x,y) [] = (x,y)
    posicao (x,y) (h:t) = posicao (case h of Norte -> (x,y+1)
                                             Sul -> (x,y-1)
                                             Este -> (x+1,y) 
                                             Oeste -> (x-1,y)) t

    caminho :: (Int,Int) -> (Int,Int) -> [Movimento]
    caminho (x,y) (x,y) = []
    caminho (x,y) (a,b) | a>x = Este: caminho (x+1,y) (a,b)
                        | a<x = Oeste: caminho (x-1,y) (a,b)
                        | b>y = Norte: caminho (x,y+1) (a,b)
                        | bzy = Sul: caminho (x,y-1) (a,b)
                        | otherwise = []

vertical' :: [Movimento] -> Bool
vertical' [] = True
vertical' (h:t) = case  h of Este -> False
                             Oeste -> False
                             otherwise -> vertical' t


data Posicao = Pos Int Int  deriving Show

    
    mesmaOrdenada :: [Posicao] -> Bool
    mesmaOrdenada [] = False
    mesmaOrdenada [(Pos x y)] = True
    mesmaOrdenada [(Pos x y):(Pos a b):t] | y==b = mesmaOrdenada (Pos a b):t
                                          | otherwise = False 

--50)
data Semaforo = Verde | Amarelo | Vermelho deriving Show

intersecaoOK :: [Semaforo] -> Bool
intersecaoOK [] = False
intersecaoOK  (s1:s2)   | s1 == Vermelho && s2 == _ = True
                        | s2 == Vermelho && s1 == _ = True
                        | otherwise = False 

--14)

inits':: [a]->[[a]]
inits' [] = [[]]
inits' l = inits' (aux l) ++ [l]

--tira o ultimo elemento da lista
init :: [a] -> [a]
init (h:[]) = []
init (h:t) = h : aux t


--24)

intersect' :: Eq a => [a] -> [a] -> [a]
intersect' [] _ = []
intersect' _ [] = []
intersect' (h:t) (x:xs) | elem h (x:xs) = h:intersect' t (x:xs)
                        | otherwise = intersect' t (x:xs)

--25)
insert' :: Ord a => a -> [a] -> [a]
insert' n [] = [a]
insert' n (h:t) | n <= h = n:(h:t)
                | otherwise = h: insert' n t 

--2)

enumFromThenTo' :: Int -> Int -> Int -> [Int]
enumfromthento' _ 0 _ = []
enumfromthento' x y z | x<z = x:(enumfromthento' (x+(y-1)) y z)
                      | otherwise = []

--28)????????????????

pMaior' :: Ord a => [a] -> Int
pMaior' (h:t) = aux2 1 (h,0) t 


aux2:: Int -> (a,Int) -> [a] -> Int
aux2 p (m,pm) [] = pm
aux2 p (m,pm) (h:t) | m>=h = aux2(p+1) (m,pm) t
                    | otherwise = aux2 (p+1) (h,p) t


--19)
elemIndices :: Eq a => a -> [a] -> [Int
elemIndices x l = aux3 0 x l

aux3 :: Eq a => Int -> a -> [a] -> [Int]
aux3 p x [] = []
aux3 p x (h:t) | x == h = p:(aux3 (p+1) x t)
               | x/= = aux3 (p+1) x t 









