any' :: (a -> Bool) -> [a] -> Bool
any' p [] = False
any' p (h:t) = if p h then True
              else any' p t


zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' func [] l = []
zipWith' func l [] = []
zipWith' func (h:t) (x:xs) = func h x : zipWith' func t xs

takeWhile' :: (a -> Bool) -> [a] -> [a]
takeWhile' func [] = []
takeWhile' func (h:t) | func h == True = h: takeWhile' func t
                      | otherwise = []

dropWhile' :: (a -> Bool) -> [a] -> [a]
dropWhile' func [] = []
dropWhile' func (h:t) | func h == True = dropWhile' func t
                      | otherwise = h:t

span' :: (a -> Bool) -> [a] -> ([a],[a])
span' p l = (takeWhile' p l, dropWhile' p l)

span'' :: (a -> Bool) -> [a] -> ([a],[a])
span'' p [] = ([],[])
span'' p (x:xs) | p x == False = ([],(x:xs))
               | p x = (x : a, snd (span'' p xs))
               where a = fst (span'' p xs)

--deleteBy' :: (a -> a -> Bool) -> a -> [a] -> [a]
--deleteBy' 

type Polinomio = [Monomio]
type Monomio = (Float,Int)

--2x³+3x⁴+5x³+4x⁵
p:: Polinomio
p = [(2,3),(3,4),(5,3),(4,5)]


selgrau :: Int -> Polinomio -> Polinomio
selgrau e p = filter (eDoGrau) p 


eDoGrau :: Int -> Monomio -> Bool
eDoGrau i (c,e) = i==e

selgrau'' :: Int -> Polinomio -> Polinomio
selgrau'' e p = filter (\(c,exp)-> e==exp) p 

conta:: Int -> Polinomio -> Int
conta x p = length (selgrau e p)

deriv:: Polinomio -> Polinomio
deriv p = map (\(c,e)->(c=c*e,e-1)) p 






