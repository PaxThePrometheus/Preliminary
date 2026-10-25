usd_prices = [12.50, 25.00, 49.99, 99.95, 120.00, 249.00]

exchange_rate = 0.87

eur_prices = [round(price * exchange_rate, 2) for price in usd_prices]

print("USD Prices to EUR Prices")
for usd, eur in zip(usd_prices, eur_prices):
    print(f"${usd:<8.2f} > €{eur:.2f}")