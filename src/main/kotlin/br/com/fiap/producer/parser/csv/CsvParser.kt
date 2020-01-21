package br.com.fiap.producer.parser.csv

import br.com.fiap.producer.parser.FileParser
import br.com.fiap.producer.parser.vo.FileLayout
import com.opencsv.bean.ColumnPositionMappingStrategy
import com.opencsv.bean.CsvToBeanBuilder
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Paths


@Component
class CsvParser : FileParser<FileLayout> {

    override fun parseFile(path: String, beanType: Class<FileLayout>): List<FileLayout> {
        val ms = ColumnPositionMappingStrategy<FileLayout>()
        ms.type = beanType

        val reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(path).toURI()))
        val cb = CsvToBeanBuilder<FileLayout>(reader)
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .withType(beanType)
                .withMappingStrategy(ms)
                .withSkipLines(1)
                .build()

        val entries = cb.parse()
        reader.close()
        return entries
    }


}