package br.com.fiap.producer.parser.vo

data class FileLayout(
    val mesReferencia: String = "",
    val mesCompetencia: String = "",
    val uf: String = "",
    val codMunicipioSiafi: String = "",
    val nomeMunicipio: String = "",
    val nisFavorecido: String = "",
    val nomeFavorecido: String = "",
    val valorParcela: String = ""
)