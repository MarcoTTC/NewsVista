package br.com.marcottc.newsvista.model.mock

import br.com.marcottc.newsvista.model.remote.MultimediaRemote
import br.com.marcottc.newsvista.model.remote.TopStoriesNewsRetrievalRemote
import br.com.marcottc.newsvista.model.remote.TopStoriesArticleRemote

class MockGenerator {

    companion object {

        fun generateTopStoriesNewsRetrievalData(): TopStoriesNewsRetrievalRemote {
            return TopStoriesNewsRetrievalRemote(
                status = "OK",
                copyright = "Copyright (c) 2024 The New York Times Company. All Rights Reserved.",
                section = "home",
                lastUpdated = "2024-07-16T14:57:08-04:00",
                numResults = 3,
                resultList = generateTopStoriesArticleDataList()
            )
        }

        fun generateTopStoriesArticleDataList(): List<TopStoriesArticleRemote> {
            return listOf(
                TopStoriesArticleRemote(
                    section = "world",
                    subsection = "europe",
                    title = "At Ukraine’s Largest Children’s Hospital, a Horrific Scene of Destruction",
                    abstract = "Families and patients were not unfamiliar with the sound of missiles flying overhead. But the Russian assault on the hospital marked one of the worst days of violence against civilians in months.",
                    url = "https://www.nytimes.com/2024/07/09/world/europe/ukraine-childrens-hospial-russia.html",
                    uri = "nyt://article/d6bebda3-3565-5f3f-a78e-ae4f902d73e5",
                    byline = "By Marc Santora, Megan Specia and Brendan Hoffman",
                    itemType = "Article",
                    updatedDate = "2024-07-09T14:56:04-04:00",
                    createdDate = "2024-07-09T14:38:39-04:00",
                    publishedDate = "2024-07-09T14:38:39-04:00",
                    materialTypeFacet = "",
                    kicker = "",
                    desFacet = listOf(
                        "Civilian Casualties",
                        "Deaths (Fatalities)",
                        "Missiles and Missile Defense Systems",
                        "Hospitals",
                        "Russian Invasion of Ukraine (2022)",
                        "Defense and Military Forces",
                        "Children and Childhood",
                        "Bombs and Explosives",
                        "Cancer",
                        "International Relations"
                    ),
                    orgFacet = emptyList(),
                    perFacet = listOf(
                        "Biden, Joseph R Jr"
                    ),
                    geoFacet = listOf(
                        "Kyiv (Ukraine)"
                    ),
                    multimediaList = listOf(
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-superJumbo.jpg",
                            format = "Super Jumbo",
                            height = 1366,
                            width = 2048,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-threeByTwoSmallAt2X.jpg",
                            format = "threeByTwoSmallAt2X",
                            height = 400,
                            width = 600,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-thumbLarge.jpg",
                            format = "Large Thumbnail",
                            height = 150,
                            width = 150,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        )
                    ),
                    shortUrl = ""
                ),
                TopStoriesArticleRemote(
                    section = "world",
                    subsection = "europe",
                    title = "The Surgeon",
                    abstract = "A single image captures a day of horror at a children’s hospital in Ukraine hit by a Russian missile.",
                    url = "https://www.nytimes.com/2024/07/08/world/europe/ohmatdyt-hospital-surgeon.html",
                    uri = "nyt://article/1f627cbd-47cc-5c57-88e1-bc179b066e15",
                    byline = "By Brendan Hoffman",
                    itemType = "Article",
                    updatedDate = "2024-07-09T03:28:27-04:00",
                    createdDate = "2024-07-08T16:58:09-04:00",
                    publishedDate = "2024-07-08T16:58:09-04:00",
                    materialTypeFacet = "",
                    kicker = "In One Image",
                    desFacet = listOf(
                        "Russian Invasion of Ukraine (2022)",
                        "Civilian Casualties",
                        "Hospitals",
                        "Photography"
                    ),
                    orgFacet = emptyList(),
                    perFacet = emptyList(),
                    geoFacet = listOf(
                        "Kyiv (Ukraine)",
                        "Ukraine",
                        "Russia"
                    ),
                    multimediaList = listOf(
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/08/world/oneimageukraine/oneimageukraine-superJumbo.png",
                            format = "Super Jumbo",
                            height = 1080,
                            width = 1620,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/08/world/oneimageukraine/oneimageukraine-threeByTwoSmallAt2X.png",
                            format = "threeByTwoSmallAt2X",
                            height = 400,
                            width = 600,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/08/world/oneimageukraine/oneimageukraine-thumbLarge.png",
                            format = "Large Thumbnail",
                            height = 150,
                            width = 150,
                            type = "image",
                            subtype = "photo",
                            caption = "",
                            copyright = "Brendan Hoffman for The New York Times"
                        )
                    ),
                    shortUrl = ""
                ),
                TopStoriesArticleRemote(
                    section = "world",
                    subsection = "europe",
                    title = "Russian Court Orders Arrest of Yulia Navalnaya, Navalny’s Widow",
                    abstract = "The court accused Ms. Navalnaya, who left Russia in 2021, of “participating in an extremist community.” She would be subject to arrest if she ever returns to Russia, the court said.",
                    url = "https://www.nytimes.com/2024/07/09/world/europe/russia-yulia-navalnaya-arrest-order.html",
                    uri = "nyt://article/ab7f3e29-cd2d-5673-9bfe-05d799089dd8",
                    byline = "By Neil MacFarquhar",
                    itemType = "Article",
                    updatedDate = "2024-07-09T14:12:32-04:00",
                    createdDate = "2024-07-09T14:08:46-04:00",
                    publishedDate = "2024-07-09T14:08:46-04:00",
                    materialTypeFacet = "",
                    kicker = "",
                    desFacet = listOf(
                        "Political Prisoners",
                        "Decisions and Verdicts",
                        "Deaths (Fatalities)"
                    ),
                    orgFacet = emptyList(),
                    perFacet = listOf(
                        "Navalnaya, Yulia B",
                        "Navalny, Aleksei A",
                        "Putin, Vladimir V"
                    ),
                    geoFacet = listOf(
                        "Russia"
                    ),
                    multimediaList = listOf(
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09russia-Navalnaya-1-pwzg/09russia-Navalnaya-1-pwzg-superJumbo.jpg",
                            format = "Super Jumbo",
                            height = 1378,
                            width = 2048,
                            type = "image",
                            subtype = "photo",
                            caption = "Yulia Navalnaya, the widow of Aleksei A. Navalny, the late Kremlin opposition leader, at a rally in March in Berlin, where voters lined up to cast their ballots in Russia’s presidential election.",
                            copyright = "Tobias Schwarz/Agence France-Presse — Getty Images"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09russia-Navalnaya-1-pwzg/09russia-Navalnaya-1-pwzg-threeByTwoSmallAt2X.jpg",
                            format = "threeByTwoSmallAt2X",
                            height = 400,
                            width = 600,
                            type = "image",
                            subtype = "photo",
                            caption = "Yulia Navalnaya, the widow of Aleksei A. Navalny, the late Kremlin opposition leader, at a rally in March in Berlin, where voters lined up to cast their ballots in Russia’s presidential election.",
                            copyright = "Tobias Schwarz/Agence France-Presse — Getty Images"
                        ),
                        MultimediaRemote(
                            url = "https://static01.nyt.com/images/2024/07/09/multimedia/09russia-Navalnaya-1-pwzg/09russia-Navalnaya-1-pwzg-thumbLarge.jpg",
                            format = "Large Thumbnail",
                            height = 150,
                            width = 150,
                            type = "image",
                            subtype = "photo",
                            caption = "Yulia Navalnaya, the widow of Aleksei A. Navalny, the late Kremlin opposition leader, at a rally in March in Berlin, where voters lined up to cast their ballots in Russia’s presidential election.",
                            copyright = "Tobias Schwarz/Agence France-Presse — Getty Images"
                        )
                    ),
                    shortUrl = ""
                )
            )
        }

        fun generateTopStoriesSingleArticleData() = TopStoriesArticleRemote(
            section = "world",
            subsection = "europe",
            title = "At Ukraine’s Largest Children’s Hospital, a Horrific Scene of Destruction",
            abstract = "Families and patients were not unfamiliar with the sound of missiles flying overhead. But the Russian assault on the hospital marked one of the worst days of violence against civilians in months.",
            url = "https://www.nytimes.com/2024/07/09/world/europe/ukraine-childrens-hospial-russia.html",
            uri = "nyt://article/d6bebda3-3565-5f3f-a78e-ae4f902d73e5",
            byline = "By Marc Santora, Megan Specia and Brendan Hoffman",
            itemType = "Article",
            updatedDate = "2024-07-09T14:56:04-04:00",
            createdDate = "2024-07-09T14:38:39-04:00",
            publishedDate = "2024-07-09T14:38:39-04:00",
            materialTypeFacet = "",
            kicker = "",
            desFacet = listOf(
                "Civilian Casualties",
                "Deaths (Fatalities)",
                "Missiles and Missile Defense Systems",
                "Hospitals",
                "Russian Invasion of Ukraine (2022)",
                "Defense and Military Forces",
                "Children and Childhood",
                "Bombs and Explosives",
                "Cancer",
                "International Relations"
            ),
            orgFacet = emptyList(),
            perFacet = listOf(
                "Biden, Joseph R Jr"
            ),
            geoFacet = listOf(
                "Kyiv (Ukraine)"
            ),
            multimediaList = listOf(
                MultimediaRemote(
                    url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-superJumbo.jpg",
                    format = "Super Jumbo",
                    height = 1366,
                    width = 2048,
                    type = "image",
                    subtype = "photo",
                    caption = "",
                    copyright = "Brendan Hoffman for The New York Times"
                ),
                MultimediaRemote(
                    url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-threeByTwoSmallAt2X.jpg",
                    format = "threeByTwoSmallAt2X",
                    height = 400,
                    width = 600,
                    type = "image",
                    subtype = "photo",
                    caption = "",
                    copyright = "Brendan Hoffman for The New York Times"
                ),
                MultimediaRemote(
                    url = "https://static01.nyt.com/images/2024/07/09/multimedia/09ukraine-children-01-hpvl-promo/09ukraine-children-01-hpvl-thumbLarge.jpg",
                    format = "Large Thumbnail",
                    height = 150,
                    width = 150,
                    type = "image",
                    subtype = "photo",
                    caption = "",
                    copyright = "Brendan Hoffman for The New York Times"
                )
            ),
            shortUrl = ""
        )
    }
}