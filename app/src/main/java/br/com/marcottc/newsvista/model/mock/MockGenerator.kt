package br.com.marcottc.newsvista.model.mock

import br.com.marcottc.newsvista.model.TopArticleRemote

class MockGenerator {

    companion object {

        fun generateTopArticleData(): List<TopArticleRemote> {
            return (1..10).map {
                TopArticleRemote(
                    section = "us",
                    subsection = "politics",
                    title = " $it Biden’s Strategy to Make the Race About Trump Is Suddenly in Doubt",
                    abstract = "The Biden campaign’s effort to raise questions about Donald J. Trump’s ability to be president has boomeranged into a referendum on the president’s own competence.",
                    url = "https://www.nytimes.com/2024/07/08/us/politics/biden-trump-strategy.html",
                    byline = "By Reid J. Epstein",
                    itemType = "Article",
                    updatedDate = "2024-07-08T07:11:05-04:00",
                    createdDate = "2024-07-08T05:03:24-04:00"
                )
            }
        }
    }
}