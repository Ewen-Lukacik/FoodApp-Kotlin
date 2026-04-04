package com.example.foodapp_kotlin.local

import com.example.foodapp_kotlin.local.database.AppDatabase
import com.example.foodapp_kotlin.local.entity.*

object DatabaseSeeder {
    suspend fun seedDatabase(db: AppDatabase) {
        val recipeDao = db.recipeDao()
        val categoryDao = db.categoryDao()
        val ingredientDao = db.ingredientDao()

        // Check if already seeded
        if (categoryDao.getAllCategories().isNotEmpty()) return

        // 1. Insert Categories
        val categories = listOf(
            Category(id = 1, name = "Italien",  description = "Plats traditionnels italiens", image = "food_italian"),
            Category(id = 2, name = "Pizza",    description = "Toutes sortes de pizzas",      image = "food_pizza"),
            Category(id = 3, name = "Burger",   description = "Burgers gourmets",             image = "food_burger"),
            Category(id = 4, name = "Salade",   description = "Fraîcheur et santé",           image = "food_salade"),
            Category(id = 5, name = "Dessert",  description = "Douceurs sucrées",             image = "food_dessert")
        )
        categories.forEach { categoryDao.insertCategory(it) }

        // 2. Insert Ingredients
        val ingredients = listOf(
            Ingredient(id = 1,  name = "Pâtes",           price = 2, type = "Base"),
            Ingredient(id = 2,  name = "Tomate",          price = 1, type = "Légume"),
            Ingredient(id = 3,  name = "Fromage",         price = 3, type = "Laitage"),
            Ingredient(id = 4,  name = "Basilic",         price = 1, type = "Herbe"),
            Ingredient(id = 5,  name = "Lardons",         price = 4, type = "Viande"),
            Ingredient(id = 6,  name = "Steak haché",     price = 5, type = "Viande"),
            Ingredient(id = 7,  name = "Pain Burger",     price = 2, type = "Base"),
            Ingredient(id = 8,  name = "Poulet",          price = 5, type = "Viande"),
            Ingredient(id = 9,  name = "Laitue",          price = 1, type = "Légume"),
            Ingredient(id = 10, name = "Crème fraîche",   price = 2, type = "Laitage"),
            Ingredient(id = 11, name = "Oeuf",            price = 1, type = "Base"),
            Ingredient(id = 12, name = "Riz",             price = 1, type = "Base"),
            Ingredient(id = 13, name = "Aubergine",       price = 2, type = "Légume"),
            Ingredient(id = 14, name = "Courgette",       price = 2, type = "Légume"),
            Ingredient(id = 15, name = "Jambon",          price = 3, type = "Viande"),
            Ingredient(id = 16, name = "Champignons",     price = 2, type = "Légume"),
            Ingredient(id = 17, name = "Oignon",          price = 1, type = "Légume"),
            Ingredient(id = 18, name = "Avocat",          price = 2, type = "Légume"),
            Ingredient(id = 19, name = "Crevettes",       price = 6, type = "Poisson"),
            Ingredient(id = 20, name = "Farine",          price = 1, type = "Base"),
            Ingredient(id = 21, name = "Beurre",          price = 2, type = "Laitage"),
            Ingredient(id = 22, name = "Sucre",           price = 1, type = "Base"),
            Ingredient(id = 23, name = "Chocolat",        price = 3, type = "Base"),
            Ingredient(id = 24, name = "Fraises",         price = 3, type = "Fruit"),
            Ingredient(id = 25, name = "Mascarpone",      price = 4, type = "Laitage"),
            Ingredient(id = 26, name = "Café",            price = 2, type = "Base"),
            Ingredient(id = 27, name = "Saumon",          price = 7, type = "Poisson"),
            Ingredient(id = 28, name = "Mozzarella",      price = 3, type = "Laitage"),
            Ingredient(id = 29, name = "Pesto",           price = 3, type = "Sauce"),
            Ingredient(id = 30, name = "Bacon",           price = 4, type = "Viande")
        )
        ingredients.forEach { ingredientDao.insertIngredient(it) }

        // 3. Insert Recipes
        val recipes = listOf(
            // Italien (id 1–6)
            Recipe(id = 1,  name = "Pâtes Carbonara",         description = "Les vraies carbonara italiennes",        time = 25, difficulty = 2, image = "recipe_1",  price = 12, note = 4.8, instructions = "1. Faites bouillir une grande casserole d'eau salée.\n2. Cuisez les pâtes selon les instructions du paquet.\n3. Faites dorer la guanciale dans une poêle.\n4. Mélangez les œufs et le pecorino dans un bol avec beaucoup de poivre noir.\n5. Égouttez les pâtes (réservez un peu d'eau de cuisson), mélangez avec la guanciale hors du feu.\n6. Ajoutez le mélange œufs/fromage, mélangez vivement avec un peu d'eau de cuisson pour créer une crème.\n7. Servez immédiatement !"),
            Recipe(id = 2,  name = "Risotto aux champignons", description = "Risotto crémeux aux champignons",        time = 35, difficulty = 3, image = "recipe_2",  price = 13, note = 4.6, instructions = "1. Chauffez le bouillon de légumes.\n2. Faites revenir un oignon haché et les champignons émincés dans du beurre ou de l'huile d'olive.\n3. Ajoutez le riz Arborio et nacrez-le.\n4. Déglacez au vin blanc (optionnel).\n5. Ajoutez progressivement le bouillon chaud louche par louche en remuant constamment jusqu'à absorption complète.\n6. Retirez du feu, ajoutez une bonne cuillère de beurre et de parmesan râpé, puis mélangez vigoureusement.\n7. Laissez reposer 2 minutes et servez."),
            Recipe(id = 3,  name = "Lasagnes",                description = "Lasagnes à la bolognaise maison",        time = 60, difficulty = 3, image = "recipe_3",  price = 15, note = 4.9, instructions = "1. Préparez la sauce bolognaise (viande hachée, tomates, oignons, carottes).\n2. Préparez la sauce béchamel (beurre, farine, lait, muscade).\n3. Préchauffez le four à 180°C.\n4. Dans un plat allant au four, alternez les couches : pâte à lasagne, bolognaise, béchamel, et quelques morceaux de mozzarella ou parmesan.\n5. Terminez par la béchamel et parsemez généreusement de fromage râpé.\n6. Enfournez pendant 30 à 40 minutes jusqu'à ce que le dessus soit gratiné."),
            Recipe(id = 4,  name = "Penne all'Arrabbiata",    description = "Pâtes épicées à la sauce tomate",       time = 20, difficulty = 1, image = "recipe_4",  price = 10, note = 4.3, instructions = "1. Cuisez les penne dans l'eau bouillante salée.\n2. Pendant ce temps, faites revenir de l'ail haché et des piments rouges émincés dans l'huile d'olive.\n3. Ajoutez les tomates concassées ou purée de tomates et laissez mijoter 10-15 minutes.\n4. Égouttez les pâtes et incorporez-les à la sauce.\n5. Parsemez de persil frais et servez chaud !"),
            Recipe(id = 5,  name = "Gnocchis au pesto",       description = "Gnocchis maison au pesto basilic",      time = 40, difficulty = 3, image = "recipe_5",  price = 14, note = 4.7, instructions = "1. Préparez un pesto en mixant basilic frais, pignons, ail, parmesan et huile d'olive.\n2. Dans une casserole, portez l'eau à ébullition et plongez les gnocchis.\n3. Dès que les gnocchis remontent à la surface, ils sont cuits ! Égouttez-les.\n4. Mélangez doucement les gnocchis avec le pesto frais.\n5. Servez avec des pignons de pin toastés par-dessus."),
            Recipe(id = 6,  name = "Tagliatelles au saumon",  description = "Tagliatelles crème et saumon fumé",     time = 20, difficulty = 2, image = "recipe_6",  price = 16, note = 4.5, instructions = "1. Mettez les tagliatelles à cuire.\n2. Émincez une échalote et faites-la revenir dans une poêle avec un filet d'huile.\n3. Coupez le saumon fumé ou frais en morceaux et ajoutez-le.\n4. Versez la crème fraîche, baissez le feu et laissez épaissir.\n5. Mélangez la sauce avec les tagliatelles égouttées, ajoutez un filet de jus de citron et de l'aneth."),

            // Pizza (id 7–12)
            Recipe(id = 7,  name = "Pizza Margherita",        description = "La reine des pizzas",                   time = 20, difficulty = 1, image = "recipe_7",  price = 10, note = 4.4, instructions = "1. Préchauffez le four au maximum (250°C ou +).\n2. Étalez la pâte à pizza.\n3. Répartissez la sauce tomate de façon homogène.\n4. Ajoutez des morceaux de mozzarella fraîche déchirée à la main.\n5. Enfournez pour environ 8 à 12 minutes.\n6. À la sortie du four, ajoutez des feuilles de basilic frais et un trait d'huile d'olive."),
            Recipe(id = 8,  name = "Pizza Quatre Fromages",   description = "Pizza généreuse aux 4 fromages",        time = 25, difficulty = 2, image = "recipe_8",  price = 13, note = 4.8, instructions = "1. Étalez la pâte à pizza.\n2. Vous pouvez utiliser une base crème fraîche ou tomate selon vos goûts.\n3. Répartissez la mozzarella, le gorgonzola (ou roquefort), du chèvre et du parmesan équitablement.\n4. Enfournez à 250°C jusqu'à ce que les fromages fondent et soient légèrement gratinés.\n5. Laissez tiédir une minute avant de couper."),
            Recipe(id = 9,  name = "Pizza Jambon-Champignons",description = "Classique indémodable",                 time = 25, difficulty = 1, image = "recipe_9",  price = 11, note = 4.2, instructions = "1. Étalez la pâte et appliquez la sauce tomate.\n2. Émincez finement les champignons de Paris frais.\n3. Disposez des morceaux de jambon blanc et les champignons sur la pâte.\n4. Parsemez de mozzarella râpée et d'un peu d'origan.\n5. Cuisez au four très chaud pendant 10 à 15 minutes."),
            Recipe(id = 10, name = "Pizza Pesto-Poulet",      description = "Pizza au pesto et poulet grillé",       time = 30, difficulty = 2, image = "recipe_10", price = 13, note = 4.6, instructions = "1. Étalez la pâte. Au lieu de la tomate, étalez une fine couche de pesto.\n2. Ajoutez des morceaux de poulet préalablement grillés à la poêle.\n3. Parsemez de tomates cerises coupées en deux et de mozzarella.\n4. Enfournez 10 minutes.\n5. Ajoutez un peu de roquette fraîche à la sortie avant de servir."),
            Recipe(id = 11, name = "Pizza Végétarienne",      description = "Légumes grillés et mozzarella",         time = 25, difficulty = 1, image = "recipe_11", price = 11, note = 4.1, instructions = "1. Faites légèrement poêler des rondelles de courgettes, aubergines et poivrons.\n2. Étalez la pâte, ajoutez la sauce tomate.\n3. Disposez harmonieusement vos légumes préalablement préparés.\n4. Ajoutez la mozzarella et de l'origan.\n5. Faites cuire au four très chaud jusqu'à ce que la pâte soit bien croustillante."),
            Recipe(id = 12, name = "Calzone",                 description = "Pizza pliée farcie au jambon",          time = 30, difficulty = 3, image = "recipe_12", price = 12, note = 4.7, instructions = "1. Étalez la pâte sous forme de disque.\n2. Sur une moitié seulement, étalez sauce tomate, jambon, champignons et fromages.\n3. Repliez l'autre moitié par-dessus pour former un chausson.\n4. Pincez très bien les bords pour les souder (ourlet).\n5. Étalez un peu de sauce tomate et de fromage sur le dessus.\n6. Enfournez environ 15 minutes."),

            // Burger (id 13–17)
            Recipe(id = 13, name = "Cheeseburger",            description = "Burger classique avec beaucoup de fromage", time = 15, difficulty = 2, image = "recipe_13", price = 14, note = 4.5, instructions = "1. Faites dorer les pains à burger coupés en deux.\n2. Mettez le steak à cuire très chaud dans une poêle.\n3. Une minute avant la fin de cuisson, déposez la tranche de cheddar sur le steak pour qu'elle fonde.\n4. Tartinez la base du pain avec votre sauce favorite (ketchup/moutarde).\n5. Disposez le steak au cheddar, la salade, la tomate, les cornichons, et refermez !"),
            Recipe(id = 14, name = "Bacon Burger",            description = "Burger avec bacon croustillant",        time = 15, difficulty = 2, image = "recipe_14", price = 15, note = 4.8, instructions = "1. Faites cuire les tranches de poitrine fumée jusqu'à ce qu'elles soient très croustillantes.\n2. Dans la même poêle, faites cuire votre steak.\n3. Ajoutez le fromage sur le steak pour le faire fondre.\n4. Montez votre burger : sauce, viande fromage, lanières de bacon croustillant, petite salade.\n5. Dégustez avec des frites maison."),
            Recipe(id = 15, name = "Chicken Burger",          description = "Burger au poulet croustillant",         time = 20, difficulty = 2, image = "recipe_15", price = 13, note = 4.3, instructions = "1. Panez vos filets de poulet : passez-les dans la farine, l'oeuf battu, puis la chapelure.\n2. Faites-les frire à la poêle ou cuire au four jusqu'à ce qu'ils soient bien dorés et cuits à l'intérieur.\n3. Préparez une mayonnaise légèrement épicée et étalez-la sur les pains toastés.\n4. Ajoutez la salade et le poulet croustillant.\n5. Refermez le burger."),
            Recipe(id = 16, name = "Burger Végétarien",       description = "Steak de légumes et avocat",            time = 20, difficulty = 2, image = "recipe_16", price = 12, note = 4.0, instructions = "1. Préparez votre galette végétale (ou utilisez-en une prête) et faites-la dorer.\n2. Écrasez l'avocat ou coupez-le en fines lamelles.\n3. Préchauffez les buns.\n4. Étalez l'avocat sur le bun inférieur, déposez la galette végétale, des tomates et un peu d'oignon rouge croquant.\n5. Fermez et savourez."),
            Recipe(id = 17, name = "Double Smash Burger",     description = "Double steak smashé façon fast-food",   time = 20, difficulty = 3, image = "recipe_17", price = 17, note = 4.9, instructions = "1. Formez des boules de viande hachée (pas trop tassées).\n2. Dans une poêle fumante, déposez les boules et écrasez-les le plus finement possible avec une spatule plate.\n3. Laissez croûter 1 bonne minute, retournez-les et ajoutez du fromage sur chaque steak.\n4. Superposez vos deux steaks.\n5. Placez-les dans le pain préparé avec de la sauce burger et refermez."),

            // Salade (id 18–22)
            Recipe(id = 18, name = "Salade César",            description = "La célèbre salade au poulet",           time = 15, difficulty = 1, image = "recipe_18", price = 11, note = 4.6, instructions = "1. Faites dorer le poulet à la poêle, puis coupez-le en tranches.\n2. Préparez la sauce César mixant anchois, ail, jaune d'oeuf, moutarde, citron, parmesan et huile.\n3. Répartissez la salade romaine dans l'assiette.\n4. Ajoutez le poulet, des croûtons faits maison, du parmesan râpé en copeaux.\n5. Nappez généreusement de la sauce."),
            Recipe(id = 19, name = "Salade Niçoise",          description = "Thon, tomates, oeufs et olives",        time = 15, difficulty = 1, image = "recipe_19", price = 10, note = 4.4, instructions = "1. Faites cuire les oeufs durs et laissez refroidir.\n2. Émiettez le thon en boîte.\n3. Coupez les tomates en quartiers et émincez de l'oignon rouge frais.\n4. Mélangez dans une assiette salade, tomates, oeufs durs, thon et de belles olives noires.\n5. Assaisonnez d'une bonne vinaigrette (huile d'olive, vinaigre, moutarde)."),
            Recipe(id = 20, name = "Salade de Crevettes",     description = "Crevettes, avocat et agrumes",          time = 10, difficulty = 1, image = "recipe_20", price = 13, note = 4.7, instructions = "1. Décortiquez les crevettes (vous pouvez les poêler rapidement avec du paprika ou les manger nature).\n2. Pelez complètement un pamplemousse ou une orange et récupérez les suprêmes.\n3. Coupez l'avocat en morceaux.\n4. Regroupez le tout avec de la mâche ou de la salade.\n5. Arrosez d'huile d'olive, poivre et jus de citron."),
            Recipe(id = 21, name = "Salade Grecque",          description = "Concombre, tomate, feta et olives",     time = 10, difficulty = 1, image = "recipe_21", price = 9, note = 4.2, instructions = "1. Coupez les concombres, tomates et oignons rouges en gros morceaux.\n2. Placez-les dans un saladier sans salade verte (la vraie recette ne contient pas de laitue !).\n3. Ajoutez la feta coupée de gros cubes par-dessus et quelques olives Kalamata.\n4. Versez généreusement de l'huile d'olive extra-vierge et de l'origan séché.\n5. Mélangez grossièrement juste avant de servir."),
            Recipe(id = 22, name = "Bowl Quinoa-Avocat",      description = "Bowl healthy au quinoa et avocat",      time = 15, difficulty = 1, image = "recipe_22", price = 12, note = 4.8, instructions = "1. Faites cuire le quinoa et laissez-le refroidir.\n2. Dans un grand bol, placez le quinoa au fond.\n3. Disposez autour : tranches d'avocat, pois chiches, radis ou autre légume croquant.\n4. Préparez une vinaigrette avec de l'huile d'olive, citron, tahini (crème de sésame) si possible.\n5. Parsemez de graines de sésame et servez."),

            // Dessert (id 23–28)
            Recipe(id = 23, name = "Tiramisu",                description = "Le dessert italien incontournable",     time = 30, difficulty = 2, image = "recipe_23", price = 8, note = 4.9, instructions = "1. Séparez les blancs et jaunes d'œufs. Montez les blancs en neige ferme.\n2. Battez les jaunes avec du sucre jusqu'à blanchiment, puis incorporez le mascarpone.\n3. Ajoutez délicatement les blancs en neige.\n4. Trempez brièvement vos biscuits cuillère dans le café tiède.\n5. Dans un plat, alternez les couches biscuits / crème.\n6. Laissez au frais au minimum 4h (laissez reposer la nuit, c'est mieux).\n7. Saupoudrez de cacao amer avant de servir."),
            Recipe(id = 24, name = "Fondant au chocolat",     description = "Cœur coulant au chocolat noir",        time = 20, difficulty = 2, image = "recipe_24", price = 7, note = 4.8, instructions = "1. Préchauffez le four très chaud (vers 200°C).\n2. Faites fondre le chocolat amer avec le beurre.\n3. Dans un bol, battez les œufs avec le sucre, puis ajoutez doucement le beurre-chocolat.\n4. Incorporez une toute petite quantité de farine.\n5. Versez dans des ramequins beurrés et enfournez environ 8-10 minutes (le cœur doit rester liquide).\n6. Régalez-vous pendant que c'est chaud !"),
            Recipe(id = 25, name = "Tarte aux fraises",       description = "Tarte fraîche et légère",               time = 45, difficulty = 3, image = "recipe_25", price = 9, note = 4.5, instructions = "1. Préparez une pâte sablée, abaissez-la et cuisez-la « à blanc ».\n2. Préparez votre crème pâtissière ou crème d'amande selon la préférence, et laissez bien refroidir.\n3. Remplissez le fond de tarte avec votre crème.\n4. Lavez, équeutez, et coupez vos belles fraises en de jolies portions régulières.\n5. Disposez les fraises joliment pardessus. Maintenez au frais jusqu'au service."),
            Recipe(id = 26, name = "Crème brûlée",            description = "Crème vanille et caramel croustillant", time = 40, difficulty = 3, image = "recipe_26", price = 8, note = 4.7, instructions = "1. Chauffez la crème liquide avec une gousse de vanille fendue. Laissez infuser.\n2. Fouettez vigoureusement vos jaunes d'œufs avec le sucre.\n3. Retirez la vanille, et versez doucement la crème sur les oeufs en remuant.\n4. Versez la préparation dans des petits plats allant au four.\n5. Cuisez-les au four au bain-marie à 100°C pendant presque 1h (la crème doit être tremblotante).\n6. Mettez au frais 2 heures. Au moment de servir, saupoudrez de cassonade puis brûlez au chalumeau !"),
            Recipe(id = 27, name = "Mousse au chocolat",      description = "Mousse aérienne au chocolat noir",      time = 20, difficulty = 2, image = "recipe_27", price = 6, note = 4.6, instructions = "1. Séparez les blancs des jaunes d'œufs.\n2. Faites fondre délicatement le chocolat au bain-marie.\n3. Montez les blancs en neige très fermes avec une petite pincée de sel.\n4. Mélangez doucement le chocolat fondu et refroidi avec les jaunes d'œufs.\n5. Incorporez les blancs en neige petit à petit en soulevant bien avec une maryse pour ne pas les casser.\n6. Répartissez en ramequins et laissez au réfrigérateur pendant 3h minimum."),
            Recipe(id = 28, name = "Panna Cotta",             description = "Panna cotta vanille et coulis fraise",  time = 20, difficulty = 1, image = "recipe_28", price = 7, note = 4.4, instructions = "1. Faites tremper la gélatine dans un bol d'eau froide.\n2. Versez la crème, le lait, le sucre et l'arôme vanille dans une casserole et portez doucement à ébullition.\n3. Retirez du feu, essorez bien les feuilles de gélatine et fouettez pour les dissoudre parfaitement dans la préparation.\n4. Versez votre liquide dans de belles verrines, et laissez prendre au réfrigérateur pendant 4 heures environ.\n5. Juste avant de servir, versez dessus du coulis de fraises ou fruits rouges.")
        )
        recipes.forEach { recipeDao.insertRecipe(it) }

        // 4. Connect Recipes to Categories
        val recipeCategoryLinks = listOf(
            // Italien
            RecipeCategoryCrossRef(1, 1),
            RecipeCategoryCrossRef(2, 1),
            RecipeCategoryCrossRef(3, 1),
            RecipeCategoryCrossRef(4, 1),
            RecipeCategoryCrossRef(5, 1),
            RecipeCategoryCrossRef(6, 1),
            // Pizza
            RecipeCategoryCrossRef(7,  2),
            RecipeCategoryCrossRef(8,  2),
            RecipeCategoryCrossRef(9,  2),
            RecipeCategoryCrossRef(10, 2),
            RecipeCategoryCrossRef(11, 2),
            RecipeCategoryCrossRef(12, 2),
            // Burger
            RecipeCategoryCrossRef(13, 3),
            RecipeCategoryCrossRef(14, 3),
            RecipeCategoryCrossRef(15, 3),
            RecipeCategoryCrossRef(16, 3),
            RecipeCategoryCrossRef(17, 3),
            // Salade
            RecipeCategoryCrossRef(18, 4),
            RecipeCategoryCrossRef(19, 4),
            RecipeCategoryCrossRef(20, 4),
            RecipeCategoryCrossRef(21, 4),
            RecipeCategoryCrossRef(22, 4),
            // Dessert
            RecipeCategoryCrossRef(23, 5),
            RecipeCategoryCrossRef(24, 5),
            RecipeCategoryCrossRef(25, 5),
            RecipeCategoryCrossRef(26, 5),
            RecipeCategoryCrossRef(27, 5),
            RecipeCategoryCrossRef(28, 5)
        )
        recipeCategoryLinks.forEach { recipeDao.insertRecipeCategoryCrossRef(it) }

        // 5. Connect Recipes to Ingredients (principaux seulement)
        val recipeIngredientLinks = listOf(
            // Carbonara
            RecipeIngredientCrossRef(1, 1), RecipeIngredientCrossRef(1, 5), RecipeIngredientCrossRef(1, 3), RecipeIngredientCrossRef(1, 11),
            // Risotto
            RecipeIngredientCrossRef(2, 12), RecipeIngredientCrossRef(2, 16), RecipeIngredientCrossRef(2, 10), RecipeIngredientCrossRef(2, 3),
            // Lasagnes
            RecipeIngredientCrossRef(3, 1), RecipeIngredientCrossRef(3, 6), RecipeIngredientCrossRef(3, 2), RecipeIngredientCrossRef(3, 3),
            // Penne Arrabbiata
            RecipeIngredientCrossRef(4, 1), RecipeIngredientCrossRef(4, 2), RecipeIngredientCrossRef(4, 17),
            // Gnocchis pesto
            RecipeIngredientCrossRef(5, 20), RecipeIngredientCrossRef(5, 29), RecipeIngredientCrossRef(5, 3),
            // Tagliatelles saumon
            RecipeIngredientCrossRef(6, 1), RecipeIngredientCrossRef(6, 27), RecipeIngredientCrossRef(6, 10),
            // Margherita
            RecipeIngredientCrossRef(7, 2), RecipeIngredientCrossRef(7, 28), RecipeIngredientCrossRef(7, 4),
            // Quatre Fromages
            RecipeIngredientCrossRef(8, 3), RecipeIngredientCrossRef(8, 28),
            // Jambon-Champignons
            RecipeIngredientCrossRef(9, 15), RecipeIngredientCrossRef(9, 16), RecipeIngredientCrossRef(9, 28),
            // Pesto-Poulet
            RecipeIngredientCrossRef(10, 29), RecipeIngredientCrossRef(10, 8), RecipeIngredientCrossRef(10, 28),
            // Végétarienne
            RecipeIngredientCrossRef(11, 13), RecipeIngredientCrossRef(11, 14), RecipeIngredientCrossRef(11, 28),
            // Calzone
            RecipeIngredientCrossRef(12, 15), RecipeIngredientCrossRef(12, 3), RecipeIngredientCrossRef(12, 28),
            // Cheeseburger
            RecipeIngredientCrossRef(13, 7), RecipeIngredientCrossRef(13, 6), RecipeIngredientCrossRef(13, 3),
            // Bacon Burger
            RecipeIngredientCrossRef(14, 7), RecipeIngredientCrossRef(14, 6), RecipeIngredientCrossRef(14, 30),
            // Chicken Burger
            RecipeIngredientCrossRef(15, 7), RecipeIngredientCrossRef(15, 8), RecipeIngredientCrossRef(15, 9),
            // Burger Végétarien
            RecipeIngredientCrossRef(16, 7), RecipeIngredientCrossRef(16, 18), RecipeIngredientCrossRef(16, 9),
            // Double Smash
            RecipeIngredientCrossRef(17, 7), RecipeIngredientCrossRef(17, 6), RecipeIngredientCrossRef(17, 3), RecipeIngredientCrossRef(17, 30),
            // César
            RecipeIngredientCrossRef(18, 9), RecipeIngredientCrossRef(18, 8), RecipeIngredientCrossRef(18, 3),
            // Niçoise
            RecipeIngredientCrossRef(19, 2), RecipeIngredientCrossRef(19, 11), RecipeIngredientCrossRef(19, 9),
            // Crevettes
            RecipeIngredientCrossRef(20, 19), RecipeIngredientCrossRef(20, 18), RecipeIngredientCrossRef(20, 9),
            // Grecque
            RecipeIngredientCrossRef(21, 2), RecipeIngredientCrossRef(21, 3), RecipeIngredientCrossRef(21, 9),
            // Bowl Quinoa
            RecipeIngredientCrossRef(22, 18), RecipeIngredientCrossRef(22, 9), RecipeIngredientCrossRef(22, 2),
            // Tiramisu
            RecipeIngredientCrossRef(23, 25), RecipeIngredientCrossRef(23, 26), RecipeIngredientCrossRef(23, 11), RecipeIngredientCrossRef(23, 22),
            // Fondant chocolat
            RecipeIngredientCrossRef(24, 23), RecipeIngredientCrossRef(24, 21), RecipeIngredientCrossRef(24, 11), RecipeIngredientCrossRef(24, 20),
            // Tarte fraises
            RecipeIngredientCrossRef(25, 24), RecipeIngredientCrossRef(25, 20), RecipeIngredientCrossRef(25, 21), RecipeIngredientCrossRef(25, 22),
            // Crème brûlée
            RecipeIngredientCrossRef(26, 10), RecipeIngredientCrossRef(26, 11), RecipeIngredientCrossRef(26, 22),
            // Mousse chocolat
            RecipeIngredientCrossRef(27, 23), RecipeIngredientCrossRef(27, 11), RecipeIngredientCrossRef(27, 22),
            // Panna Cotta
            RecipeIngredientCrossRef(28, 10), RecipeIngredientCrossRef(28, 22), RecipeIngredientCrossRef(28, 24)
        )
        recipeIngredientLinks.forEach { ingredientDao.insertRecipeIngredientCrossRef(it) }
    }
}
