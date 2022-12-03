# Cделали домашнюю работу Петра, под чутким руководством Юры, по всем правилам!

Реализовать веб сервер проставления стоимости машины
(запрещено создавать dto, mapper, service! только controller и дао).
1. Приходит следующая структура данных (заведение машины в реестр):
```
{
 "mark": "bmw",
 "model": "i320",
 "history" :
  {   
    "created_year": 2019,
    "mileage": 33000,
    "count_owners": 2
  }
}
```
2. Ожидается возможность сохранения машины в базу данных (мапа Id -> Car)
со следующими полями: марка, модель, год создания, пробег, цена.
3. Цена определяется по формуле:
если bmw - базовая цена 50000
если mercedes - базовая цена 70000
если kia - базовая цена 35000

Каждый километр уменьшает цену на 0.1 цент.
Если владелец не один, то стоимость уменьшается на 20% от цены после пробега
4. После заведения машины в реестр получаем id ответом.
5. Имеется возможность получить машину из реестра по id:
формат:
```
 { "name" : "bmw i320",
   "milleage": 33000,
   "age_car": 3,
   "price": 37600
 }
 ```

Подсказка: Получить запрос можно в виде Map<String, Object>.
