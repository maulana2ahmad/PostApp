# PostApp
POS API Create a resource User used Retrofit MVVM


### Priview
![sasasasas](https://user-images.githubusercontent.com/43386555/61113611-da01ce80-a4b8-11e9-83ad-171cb5cae6d6.gif)

API POST https://jsonplaceholder.typicode.com/guide.html
BEST_URL = "https://jsonplaceholder.typicode.com";

## Create a resource
    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: JSON.stringify({
          title: 'foo',
          body: 'bar',
          userId: 1
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
      .then(response => response.json())
      .then(json => console.log(json))

    // Output
    {
      id: 101,
      title: 'foo',
      body: 'bar',
      userId: 1
    }

## dependencies
    dependencies {
        def retrofitVersion = "2.6.0"
        def designVersion = "28.0.0"

        //retrofit
        implementation "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        implementation "com.squareup.retrofit2:converter-jackson:$retrofitVersion"

        //design
        implementation "com.android.support:design:$designVersion"
    }
