Meta:market tests

Scenario: Filtration and opening products
Given Yandex market main page
When Click on <topcategory> category tab in main menu
When Click on <subcategory> category link in left menu
When Set from price parameter as <pricefrom>
When Set to price parameter as <priceto>
When Set filters parameter as <filter>
When Open product in <position> position in list
Then Check what right product is open

Examples:
|topcategory|subcategory|filter|pricefrom|priceto|position|
|Электроника|Мобильные телефоны|Samsung|40000| |1|
|Электроника|Портативная акустика|JBL|13000|40000|1|
|Электроника|Наушники и Bluetooth-гарнитуры|Beats|17000|25000|1|