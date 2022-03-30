#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    while (n != 0)
    {
        cout << ((n % 2 == 0) ? "DERECHA" : "IZQUIERDA") << '\n';
        cin >> n;
    }

    return 0;
}