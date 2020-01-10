package br.com.fiap.producer.parser.vo

import com.opencsv.bean.CsvBindByPosition

data class FileLayout(
    @CsvBindByPosition(position = 0)
    val mesReferencia: String = "",

    @CsvBindByPosition(position = 1)
    val mesCompetencia: String = "",

    @CsvBindByPosition(position = 2)
    val uf: String = "",

    @CsvBindByPosition(position = 3)
    val codMunicipioSiafi: String = "",

    @CsvBindByPosition(position = 4)
    val nomeMunicipio: String = "",

    @CsvBindByPosition(position = 5)
    val nisFavorecido: String = "",

    @CsvBindByPosition(position = 6)
    val nomeFavorecido: String = "",

    @CsvBindByPosition(position = 7)
    val valorParcela: String = ""
)