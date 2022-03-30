#include <iostream>
using namespace std;

int main()
{
    int casos, n;
    cin >> casos;
    for (size_t i = 0; i < casos; i++)
    {
        cin >> n;
        int nPar = 0, nDec;
        for (size_t j = 0; j < n; j++)
        {
            cin >> nDec;
            if (nDec % 2 == 0)
            {
                nPar++;
            }
        }
        cout << nPar << '\n';
    }
    return 0;
}