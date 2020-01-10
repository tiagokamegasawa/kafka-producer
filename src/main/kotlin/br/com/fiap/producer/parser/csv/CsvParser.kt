package br.com.fiap.producer.parser.csv

import br.com.fiap.producer.parser.FileParser
import br.com.fiap.producer.parser.vo.FileLayout
import org.springframework.stereotype.Component
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.bean.ColumnPositionMappingStrategy
import java.nio.file.Files
import java.nio.file.Path


@Component
class CsvParser : FileParser<FileLayout> {

    override fun parseFile(path: String, beanType: Class<FileLayout>): List<FileLayout> {
        val ms = ColumnPositionMappingStrategy<FileLayout>()
        ms.type = beanType

        val reader = Files.newBufferedReader(Path.of(path))
        val cb = CsvToBeanBuilder<FileLayout>(reader)
            .withType(beanType)
            .withMappingStrategy(ms)
            .build()

        val entries = cb.parse()
        reader.close()
        return entries
    }


}