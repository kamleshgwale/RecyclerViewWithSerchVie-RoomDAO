package com.example.searchwithroomapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MindOrksDb")
data class Chapter(
    @PrimaryKey
    @ColumnInfo(name = "chapterName") val chapterName: String
) {
    companion object {
        fun populateData(): Array<Chapter> {
            return arrayOf<Chapter>(
                Chapter("MindOrks"),
                Chapter("GetMeAnApp"),
                Chapter("BestContentApp"),
                Chapter("Hackerspace"),
                Chapter("kamlesh"),
                Chapter("Ankit"),
                Chapter("Suraj"),
                Chapter("Abhi"),
                Chapter("Lavisha"),
                Chapter("Pooja"),
                Chapter("Chanda"),
                Chapter("Nathu"),
                Chapter("Sapna"),
                Chapter("Arjun"),
                Chapter("Mama"),
                Chapter("Kaka"),
                Chapter("Yug"),
                Chapter("Dilip"),
                Chapter("Rajnish"),
                Chapter("Bhima"),
                Chapter("Ashish"),
                Chapter("Mango"),
                Chapter("Kaju"),
                Chapter("Badam"),
                Chapter("Sailana"),
                Chapter("Gadar"),
                Chapter("Jitu"),
                Chapter("Pushpa"),
                Chapter("Ratlam"),
                Chapter("MP"),
                Chapter("MH"),
                Chapter("KA"),
                Chapter("Neemuch"),
                Chapter("Jaora"),
                Chapter("Hero"),
                Chapter("Shine"),
                Chapter("Glamour"),
                Chapter("Veda"),
                Chapter("Write"),
                Chapter("Read")
            )
        }
    }
}