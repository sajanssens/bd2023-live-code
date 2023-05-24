export class AdDao {
    markAsSold(ad: AdDto) {
        ad.sold = true
    }
}
