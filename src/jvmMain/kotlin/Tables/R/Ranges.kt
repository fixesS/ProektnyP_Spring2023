package Tables.R

enum class Nominal(val id: Int, val values: List<Int>) {
    E6(6, listOf(100,150,220,330,470,680)),
    E12(12, listOf(100,120,150,180,220,270,330,390,470,560,680,820)),
    E24(24,listOf(100,110,120,130,150,160,180,200,220,240,270,300,330,360,390,430,470,510,560,620,680,750,820,910)),
    E48(48, listOf(100,105,110,115,121,127,133,140,147,154,162,169,178,187,196,205,215,226,237,249,261,274,287,301,316,332,348,365,383,402,422,442,464,487,511,536,562,590,619,649,681,715,750,787,825,866,909,953)),
    E96(96,listOf(100,102,105,107,110,113,115,118,121,124,127,130,137,140,143,147,150,154,158,162,165,169,174,178,182,187,191,196,200,205,210,215,221,226,232,237,243,249,255,261,267,274,280,287,294,301,309,316,324,332,340,348,357,365,374,383,392,402,412,422,432,442,453,464,475,487,499,511,523,536,549,562,576,590,604,619,634,649,665,681,698,715,732,750,768,787,806,825,845,866,887,909,931,953,976)),
    E192(192,listOf(100,101,102,104,105,106,107,109,110,111,113,114,115,117,118,120,121,123,124,126,127,129,130,132,135,137,138,140,142,143,145,147,149,150,152,154,156,158,160,162,164,165,167,169,172,174,176,178,180,182,184,187,189,191,193,196,198,200,203,205,208,210,213,215,218,221,223,226,229,232,234,237,240,243,246,249,252,255,258,261,264,267,271,274,277,280,284,287,291,294,298,301,305,309,312,316,320,324,328,332,336,340,344,348,352,357,361,365,370,374,379,383,388,392,397,402,407,412,417,422,427,432,437,442,448,453,459,464,470,475,481,487,493,499,505,511,517,523,530,536,542,549,556,562,569,576,583,590,597,604,612,619,626,634,642,649,657,665,673,681,690,698,706,715,723,732,741,750,759,768,777,787,796,806,816,825,835,845,856,876,887,898,909,920,931,942,953,965,976,988));

    companion object{
        fun getListOfE():List<Int>{
            val list : MutableList<Int> = mutableListOf()
            Nominal.values().map { list.add(it.id) }
            return list
        }
        fun getById(id :Int ): Nominal {
            var E : Nominal = Nominal.E6
            Nominal.values().map {
                if(it.id == id){
                    E = it
                }
            }
            return E
        }
        fun getClosestById(id:Int,value:Float): Double {
            if(id==6){
                return E_6(value.toDouble())
            }else if(id == 12){
                return E_12(value.toDouble())
            }else if(id == 24){
                return E_24(value.toDouble())
            }else{
                return CloseR(value.toDouble(),id).roundTo(3);
            }
        }
        private fun findZeros(value: Float): Double{
            val num  = value.toInt().toString().length - 1;
            val result = value/ Math.pow(10.0,num.toDouble())
            return result;
        }
        fun E_6(Val: Double): Double {
            if (Val <= 0) {
                return 0.0
            }
            val Clist = "1,1.5,2.2,3.3,4.7,6.8,10"
            val Vals = Clist.split(",").map { it.toDouble() }.toTypedArray() //convert to zero based array;
            val n = Vals.size
            //find mantissa & exponent of Val;
            val Expo = Math.floor(Math.log10(Val))
            val Mant = Val / Math.pow(10.0, Expo)
            var min_dist = 1000.0
            var closest = 0
            for (i in 0 until n) {
                val dist = Math.abs(Mant - Vals[i])
                if (dist < min_dist) {
                    min_dist = dist
                    closest = i
                }
            }
            return (Vals[closest] * Math.pow(10.0, Expo)).roundTo(3)
        }
        fun E_12(Val: Double): Double {
            if (Val <= 0) {
                return 0.0
            }
            val Clist = "1,1.2,1.5,1.8,2.2,2.7,3.3,3.9,4.7,5.6,6.8,8.2,10"
            val Vals = Clist.split(",").map { it.toDouble() }.toTypedArray() //convert to zero based array;
            val n = Vals.size
            //find mantissa & exponent of Val;
            val Expo = Math.floor(Math.log10(Val))
            val Mant = Val / Math.pow(10.0, Expo)
            var min_dist = 1000.0
            var closest = 0
            for (i in 0 until n) {
                val dist = Math.abs(Mant - Vals[i])
                if (dist < min_dist) {
                    min_dist = dist
                    closest = i
                }
            }
            return (Vals[closest] * Math.pow(10.0, Expo)).roundTo(3)
        }
        fun E_24(Val: Double): Double {
            if (Val <= 0) {
                return 0.0
            }
            val Clist = "1,1.1,1.2,1.3,1.5,1.6,1.8,2.0,2.2,2.4,2.7,3.0,3.3,3.6,3.9,4.3,4.7,5.1,5.6,6.2,6.8,7.5,8.2,9.1,10"
            val Vals = Clist.split(",").map { it.toDouble() }.toTypedArray() //convert to zero based array;
            val n = Vals.size
            //find mantissa & exponent of Val;
            val Expo = Math.floor(Math.log10(Val))
            val Mant = Val / Math.pow(10.0, Expo)
            var min_dist = 1000.0
            var closest = 0
            for (i in 0 until n) {
                val dist = Math.abs(Mant - Vals[i])
                if (dist < min_dist) {
                    min_dist = dist
                    closest = i
                }
            }
            return (Vals[closest] * Math.pow(10.0, Expo)).roundTo(3)
        }
        fun CloseR(Rval: Double, IEASeries: Int): Double {
            if (Rval <= 0) {
                return 0.0
            }
            val Expo = Math.floor(Math.log(Rval) / Math.log(10.0))
            val Mant = Rval / Math.pow(10.0, Expo)
            var x = Math.floor(IEASeries * Math.log(Mant) / Math.log(10.0))
            var min_dist = 1000.0
            var closest = 0.0
            var i = x-1.0
            while(i<=(x+1.0)){
                val y = (Math.pow(10.0, (i.toDouble() / IEASeries.toDouble()))).roundTo(2)
                val dist = Math.abs(Mant - y)
                if (dist < min_dist) {
                    min_dist = dist
                    closest = i
                }
                i+=1.0
            }
            x = (Math.pow(10.0, (closest / IEASeries.toDouble()))).roundTo(2)
            val y = Math.pow(10.0, Expo)
            return x*y
        }
        fun Double.roundTo(numDigits: Int): Double {
            val factor = Math.pow(10.0, numDigits.toDouble())
            return Math.round(this * factor) / factor
        }
    }
}