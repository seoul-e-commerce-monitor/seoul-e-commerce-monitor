package com.teamsparta.seoulecommercemonitor.csvcode.service.v1

import com.teamsparta.seoulecommercemonitor.domain.store.model.v1.Csv
import com.teamsparta.seoulecommercemonitor.domain.store.repository.v1.CsvRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class CsvCodeService(

    private val csvRepository: CsvRepository
) {
    private fun readCsv(inputStream: InputStream): List<Csv> {
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()
        val headerColumns = header.split(',')
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val columns = it.split(',', ignoreCase = false, limit = headerColumns.size).toTypedArray()
                for (i in columns.indices)
                    columns[i] = columns[i].trim()
                Csv(
                    columns[0],
                    columns[1],
                    columns[2],
                    columns[3],
                    columns[4],
                    columns[5],
                    columns[6],
                    columns[7],
                    columns[8],
                    columns[9],
                    columns[10],
                    columns[11],
                    columns[12],
                    columns[13],
                    columns[14],
                    columns[15],
                    columns[16],
                    columns[17],
                    columns[18],
                    columns[19],
                    columns[20],
                    columns[21],
                    columns[22],
                    columns[23],
                    columns[24],
                    columns[25],
                    columns[26],
                    columns[27],
                    columns[28],
                    columns[29],
                    columns[30],
                    columns[31]
                )
            }.toList()
    }

    fun readFromCsv() {
        val stores = readCsv(ClassPathResource("Seoul_Online_Shopping_Mall_Status.csv").inputStream)
        csvRepository.saveAll(stores)
    }
}