package br.com.fiap.producer.parser

interface FileParser<T> {

    fun parseFile(path: String, beanType: Class<T>): List<T>

}