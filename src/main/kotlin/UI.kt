import java.time.LocalDate

class UI(val repository: CourseRepository) {
    val mainMenu = "Inserisci r per vedere il report dei corsi oppure q per uscire"
    // r = report / q = uscita
    // ac = aggiunta nuovo corso ->chiede dati e aggiunge corso
    // ae = aggiunge edizione a un corso -> chiede id corso, e dati edizione
    // dc = cancellare corso -> id corso da cancellare
    // ic = incasso totale della scuola (non ritorna niente), ogni edizione corso ha 10 iscritti (costo x10)
    // em = id dell'edizione corso che costa di più
    // es = id dell'edizione corso che costa di meno
    // evm = valore medio costi edizione corso
    // OPZIONALE: emm = la moda (frequenza massima) delle edizioni del corso
    // OPZIONALE: eme = la mediana (valore esattamente in mezzo) delle edizioni del corso
    //val memoryRepository = MemoryRepository()
    fun start() {
        do {
            println("$mainMenu")
            var input = readLine()
            when(input) {
                "q" -> println("Usciamo dal programma")
                "r" -> {
                    //println("Stampiamo il report")
                    val elencoCorsi = repository.readCourses()
                    for(c in elencoCorsi) {
                        println("${c.report()}")
                    }

                }
                "ac" -> {
                    val corso = addCourse()
                   repository.add(corso)
                }
                "ae" -> {
                    val edition = addCourseEdition()

                }
            }
        } while(input != "q")
    }
    fun addCourse() : Corso{
        print( "inserisci ID")
        var id = readLine()!!
        print("inserisci il titolo " )
        var titolo= readLine()!!
        print("inserisci numero ore ")
        var numeroOre = readLine()!!
        print("inserisci costo ")
        var costo= readLine()!!
        print("inserisci la descrizione")
        var descrizione= readLine()!!

        print("inserisci programma ")
        var programma = readLine()!!

        print(" inserisci livello ")
        var livello = readLine()!!

        print("inserisci codice ")
        var codice = readLine()!!

        var corso = Corso(id.toInt(),titolo,numeroOre.toInt(),costo.toDouble(),descrizione,programma,
        livello,codice, mutableListOf())

        return corso

        //return "$id,$titolo,$numeroOre,$costo,$descrizione,$programma,$livello,$codice,${edizioni.size}"
    }

    //return "$id,$dataInizio,$dataFine,$codice,$numeroOre,$costo"
    fun addCourseEdition(): EdizioneCorso{


        var corso : Corso?
        do {
            print("inserisci id del corso ")
            var idCorso = readLine()!!
            corso = repository.courseById(idCorso.toInt())

        }
        while (corso == null)
        print("inserisci id  edizione ")
        var idedizione = readLine()!!
        print("inserisci  data inizio ")
        var datainizio = readLine()!!

        print("inserisci data fine ")
        var datafine = readLine()!!
        print("inserisci codice ")
        var codice = readLine()!!

        print("inserisci numero ore ")
        var numeroOre = readLine()!!

        print("inserisci il costo ")
        var costo = readLine()!!




        //var id: Int, var corso: Corso, var dataInizio: LocalDate, var dataFine: LocalDate, var codice: String,
        //var moduli: List<ModuliCorso> = listOf(), var numeroOre: Int, var costo: Double

        val edition = EdizioneCorso(idedizione.toInt(),corso, LocalDate.parse(datainizio),LocalDate.parse(datafine),codice,
            mutableListOf(),numeroOre.toInt(),costo.toDouble())

        return edition





    }
}

