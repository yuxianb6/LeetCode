import pandas as pd

def biggest_single_number(my_numbers: pd.DataFrame) -> pd.DataFrame:
    df=my_numbers
    df=my_numbers.groupby('num')['num'].size().reset_index(name='cnt')
    df=df[df['cnt']==1]
    max_value=df['num'].max()
    return pd.DataFrame({'num':[max_value]})