zipWith' :: (a->b->c) -> [a] -> [b] -> [c]
zipWith' f [] [] = []
zipWith' f x [] = []
zipWith' f [] x = []
zipWith' f (h:t) (h2:t2) = f h h2 : zipWith' f t t2 

takeWhile':: (a-> Bool) -> [a] -> [a]
takeWhile' f [] = []
takeWhile' f (h:t) | f h == True = h: takeWhile' f t
                   | otherwise = []

dropWhile :: (a -> Bool) -> [a] -> [a]
dropWhile f [] = []
dropWhile f (h:t) | f h == True = dropWhile f t
                  | otherwise = (h:t)

span':: (a -> Bool) -> [a] -> ([a],[a])
span' f (h:t) | f h == True = (h:span' f t,)

deleteBy'::(a->a->Bool) -> a -> [a] -> [a]
deleteBy' f x (h:t) | f x h == True = t
                    | otherwise = h: deleteBy' f x t




type Polinomio = [Monomio]
type Monomio = (Float,Int)

selgrau :: Int -> Polinomio -> Polinomio
selgrau x [] = []
selgrau x l = filter f l
    where f (f,i) = i == x


conta:: Int -> Polinomio -> Int
conta x p = map f p
    where f (f,i) = ()

grau:: Polinomio -> Int
grau ((a,b):t) =foldr max b second((a,b):t)

second :: Polinomio -> [Int]
second [] = []
second ((a,b):t) = b : second t  

deriv :: Polinomio -> Polinomio
deriv [] = []
deriv l = map auxd l

auxd:: Monomio -> Monomio, 
auxd (a,b) = ((fromIntegral b)*a,b-1)

calcula:: Float -> Polinomio -> Int
calcula x p = aux x p

aux :: Float -> Polinomio -> Int
aux x ((a,b):t) = (a*x)^b + aux x t 

simp :: Polinomio -> Polinomio 
simp p = map auxs p 

auxs:: Polinomio -> Polinomio
auxs ((a,b):t) | a==0 = auxs t 
               | otherwise = auxs ((a,b):t) 