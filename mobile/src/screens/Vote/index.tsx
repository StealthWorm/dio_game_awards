import React, { useEffect, useState } from 'react';
import { ScrollView, View } from 'react-native';

import { GameCard } from '../../components/Vote/GameCard';
import { Header } from '../../components/Vote/Header';

import { clientGames } from '../../api/api';

import { styles } from './styles';

export function Vote() {
  const [gameList, setGameList] = useState([{}]);

  useEffect(() => {
    (async () => {
      const response = await clientGames();
      setGameList(response)
    })()

  }, []);

  return (
    <View style={styles.container}>
      <Header />

      <ScrollView style={styles.gameArea}>
        {gameList.map(game => <GameCard props={game} />)}
      </ScrollView>
    </View>
  );
}