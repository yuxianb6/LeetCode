import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    df=courses
    df=df.groupby('class')['student'].size().reset_index(name='cnt')
    df=df[df['cnt']>=5]
    df=df[['class']]
    return df